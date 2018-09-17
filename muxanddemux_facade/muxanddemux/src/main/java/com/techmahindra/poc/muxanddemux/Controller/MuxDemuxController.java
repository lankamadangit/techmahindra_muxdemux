package com.techmahindra.poc.muxanddemux.Controller;

import com.techmahindra.poc.muxanddemux.model.Location;
import com.techmahindra.poc.muxanddemux.service.NameToAgeService;
import com.techmahindra.poc.muxanddemux.service.NameToPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping(value = "poc/mux", produces = MediaType.APPLICATION_JSON_VALUE)
class MuxDemuxController {
    @Autowired
    private NameToAgeService nameToAgeService;

    @Autowired
    private NameToPlaceService nameToPlaceService;

    @RequestMapping(method = RequestMethod.GET, value = "/location", params="name")
    DeferredResult<ResponseEntity<Location>> multiplexRequests(@RequestParam String name) {
        DeferredResult<ResponseEntity<Location>> deferredResult = new DeferredResult<ResponseEntity<Location>>();
        String age = "";
        Location location = new Location();

        location.setName(name);
        nameToAgeService.getAgeCorrespondingToName(name).subscribe(
                sub -> {
                    location.setAge(sub);
                },
                e -> deferredResult.setErrorResult(e));

        nameToPlaceService.getPlaceCorrespondingToName(name).subscribe(
                sub -> {
                    location.setPlace(sub);
                },
                e -> deferredResult.setErrorResult(e));


        deferredResult.setResult(new ResponseEntity<>(location, HttpStatus.OK));
        return deferredResult;
    }
}
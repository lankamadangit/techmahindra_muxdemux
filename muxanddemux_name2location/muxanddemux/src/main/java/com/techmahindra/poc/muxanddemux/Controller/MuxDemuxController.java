package com.techmahindra.poc.muxanddemux.Controller;

import com.techmahindra.poc.muxanddemux.model.Location;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping(value = "poc", produces = MediaType.APPLICATION_JSON_VALUE)
class MuxDemuxController {

    @RequestMapping(method = RequestMethod.GET, value = "/place", params="name")
    ResponseEntity<String>  multiplexRequests(@RequestParam String name) {
        return new ResponseEntity("Bangalore", HttpStatus.OK);
    }
}
package com.techmahindra.poc.muxanddemux.service;

import com.techmahindra.poc.muxanddemux.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
//
//@Service
//public class MuxService {
//    private RestTemplate restTemplate = new RestTemplate();
//
//    @Value("${services.location.nameservicesuri}")
//    private String NAME_SERVICE_API;
//
//    public Observable<Location> getLocations(String name) {
//        return getLocationsObservable(name);
//    }
//
//    private Observable<Location> getLocationsObservable(String name) {
//        return Observable.<Location> create(sub -> {
////            Location location = restTemplate
////                    .getForEntity(UriComponentsBuilder.fromUriString(NAME_SERVICE_API)
////                            .queryParam(name).toUriString(), Location.class)
////                    .getBody();
//            Location location = new Location("Tejaswi", "Bhimavaram");
//            sub.onNext(location);
//            sub.onCompleted();
//        }).doOnNext(c -> System.out.println("Location data was retrieved successfully."))
//                .doOnError(e -> System.out.println("An ERROR occurred while retrieving the currency rates."+e));
//    }
//}

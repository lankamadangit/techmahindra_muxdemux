package com.techmahindra.poc.muxanddemux.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import rx.Observable;

@Service
public class NameToPlaceService {
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${services.mux.nametoplaceserviceuri}")
    private String nameToPlaceServiceUri;

    public Observable<String> getPlaceCorrespondingToName(String name) {
        return getPlaceCorrespondingToNameObservable(name);
    }

    private Observable<String> getPlaceCorrespondingToNameObservable(String name) {
        return Observable.<String> create(sub -> {
            String place = restTemplate
                    .getForEntity(UriComponentsBuilder.fromUriString(nameToPlaceServiceUri+"/poc/place?name="+name)
                            .queryParam(name).toUriString(), String.class)
                    .getBody();

            sub.onNext(place);
            sub.onCompleted();
        }).doOnNext(c -> System.out.println("Location data was retrieved successfully."))
                .doOnError(e -> System.out.println("An ERROR occurred while retrieving the currency rates."+e));
    }
}

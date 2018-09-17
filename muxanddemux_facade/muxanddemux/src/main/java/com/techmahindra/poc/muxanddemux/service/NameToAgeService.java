package com.techmahindra.poc.muxanddemux.service;

import com.techmahindra.poc.muxanddemux.model.Location;
import com.techmahindra.poc.muxanddemux.model.RestResponse;
import io.netty.handler.codec.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;

@Service
public class NameToAgeService {
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${services.mux.nametoageserviceuri}")
    private String nameToAgeServiceURI;

    public Observable<String> getAgeCorrespondingToName(String name) {
        return getAgeCorrespondingToNameObservable(name);
    }

    private Observable<String> getAgeCorrespondingToNameObservable(String name) {
        return Observable.<String> create(sub -> {
            String age = restTemplate
                    .getForEntity(UriComponentsBuilder.fromUriString(nameToAgeServiceURI+"/poc/age?name="+name)
                            .queryParam(name).toUriString(), String.class)
                    .getBody();

            sub.onNext(age);
            sub.onCompleted();
        }).doOnNext(c -> System.out.println("Location data was retrieved successfully."))
                .doOnError(e -> System.out.println("An ERROR occurred while retrieving the currency rates."+e));
    }
}

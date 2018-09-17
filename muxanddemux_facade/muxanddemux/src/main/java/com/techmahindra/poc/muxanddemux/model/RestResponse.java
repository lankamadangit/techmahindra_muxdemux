package com.techmahindra.poc.muxanddemux.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class RestResponse implements Serializable {
    private String headers;
    private String body;
    private String statusCode;
    private int statusCodeValue;
    private boolean setOrExpired;
}

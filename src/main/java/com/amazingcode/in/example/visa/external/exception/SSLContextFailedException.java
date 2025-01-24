package com.amazingcode.in.example.visa.external.exception;

import lombok.Getter;

@Getter
public class SSLContextFailedException extends RuntimeException {

    private final String errorMessage;

    public SSLContextFailedException(String message){
        super(message);
        this.errorMessage = message;
    }
}

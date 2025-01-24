package com.amazingcode.in.example.visa.external.exception;

import lombok.Getter;

@Getter
public class ChangeCurrencyException extends RuntimeException {
    
    private final String errorMessage;

    public ChangeCurrencyException(String message){
        super(message);
        this.errorMessage = message;
    }
}

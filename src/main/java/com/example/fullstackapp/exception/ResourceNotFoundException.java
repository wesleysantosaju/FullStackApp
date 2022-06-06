package com.example.fullstackapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
    //CRIANDO SERIAL VERSION
    private static final long serialVersion = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}

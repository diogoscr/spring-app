package com.diogoscr.springboot.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    //criar serial
    private static final long serialVersionUID = 1L;

    //criar construtores

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id "+ id);

    }
    
}

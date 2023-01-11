package com.iotiq.appstarter.commons.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

public class EntityNotFoundException extends ApplicationException {

    public EntityNotFoundException(String entityName, Object... args) {
        super(HttpStatus.NOT_FOUND, "entityNotFound", List.of(entityName), args);
    }
}

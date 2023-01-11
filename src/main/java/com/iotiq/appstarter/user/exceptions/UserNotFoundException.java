package com.iotiq.appstarter.user.exceptions;

import com.iotiq.appstarter.commons.exceptions.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    protected UserNotFoundException(Object... args) {
        super("user", args);
    }
}

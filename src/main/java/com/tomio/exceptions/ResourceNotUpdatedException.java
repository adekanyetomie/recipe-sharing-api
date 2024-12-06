package com.tomio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ResourceNotUpdatedException extends RuntimeException {
    public ResourceNotUpdatedException(String message) {
        super(message);
    }
}

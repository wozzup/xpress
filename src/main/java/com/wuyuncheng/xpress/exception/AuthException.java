package com.wuyuncheng.xpress.exception;

import org.springframework.http.HttpStatus;

public class AuthException extends BadRequestException {

    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }

}

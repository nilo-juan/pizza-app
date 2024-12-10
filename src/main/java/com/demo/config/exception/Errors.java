package com.demo.config.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
public enum Errors implements ApplicationError {
    CUSTOMER_NOT_FOUND(NOT_FOUND, "El id: %s del cliente no existe");

    private final HttpStatus status;
    private final String message;

    @Override
    public HttpStatus getStatus() {
        return this.status;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

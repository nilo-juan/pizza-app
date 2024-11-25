package com.demo.config.exception;

import org.springframework.http.HttpStatus;

public interface ApplicationError {

    HttpStatus getStatus();
    String getCode();
    String getMessage();

}

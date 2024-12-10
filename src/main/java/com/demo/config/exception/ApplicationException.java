package com.demo.config.exception;

import java.util.Objects;
import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {

    private final ApplicationError error;

    public ApplicationException(ApplicationError ransaError, Object... args) {

        super(Objects.isNull(args) ? ransaError.getMessage() :
                String.format(ransaError.getMessage(), args));
        this.error = ransaError;
    }

    public HttpStatus getStatus() {
        return error.getStatus();
    }

    public String getErrorCode() {
        return error.getCode();
    }

}

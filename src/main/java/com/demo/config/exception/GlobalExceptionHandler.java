package com.demo.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Map<String, String>> handleCustomRuntimeException(ApplicationException ex) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("code", ex.getErrorCode());
        errorDetails.put("message", ex.getMessage());
        return new ResponseEntity<>(errorDetails, ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("code", "BAD_REQUEST");
        errorDetails.put("message", "Invalid request");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}

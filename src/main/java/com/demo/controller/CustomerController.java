package com.demo.controller;

import com.demo.dto.input.CustomerInputDto;
import com.demo.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Void> createCustomer(
            @Valid
            @RequestBody
            CustomerInputDto customerInputDto) {
        customerService.createCustomer(customerInputDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

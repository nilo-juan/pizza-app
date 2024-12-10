package com.demo.controller;

import com.demo.dto.input.CustomerInputDto;
import com.demo.dto.output.CustomerOutputDto;
import com.demo.dto.output.CustomerPaginateDto;
import com.demo.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public ResponseEntity<List<CustomerOutputDto>> listCustomers() {
        List<CustomerOutputDto> customerDtoList = customerService.listCustomers();
        return new ResponseEntity<>(customerDtoList, HttpStatus.OK);
    }

    @GetMapping("/list/active")
    public ResponseEntity<List<CustomerOutputDto>> listActiveCustomers() {
        List<CustomerOutputDto> customerDtoList = customerService.listActiveCustomers();
        return new ResponseEntity<>(customerDtoList, HttpStatus.OK);
    }

    @GetMapping("/list/paginate")
    public ResponseEntity<CustomerPaginateDto> listCustomersWithPagination(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        CustomerPaginateDto customerPaginateDto = customerService.listCustomersWithPagination(page, size);
        return new ResponseEntity<>(customerPaginateDto, HttpStatus.OK);
    }
}

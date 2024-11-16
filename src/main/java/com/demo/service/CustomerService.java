package com.demo.service;

import com.demo.dto.input.CustomerInputDto;
import com.demo.dto.output.CustomerOutputDto;
import com.demo.dto.output.CustomerPaginateDto;

import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerInputDto customerInputDto);
    List<CustomerOutputDto> listCustomers();
    List<CustomerOutputDto> listActiveCustomers();
    CustomerPaginateDto listCustomersWithPagination(Integer page, Integer size);
}

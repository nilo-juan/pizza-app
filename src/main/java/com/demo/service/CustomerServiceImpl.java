package com.demo.service;

import com.demo.dto.input.CustomerInputDto;
import com.demo.model.Customer;
import com.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void createCustomer(CustomerInputDto customerInputDto) {
        Customer customer = customerMapper(customerInputDto);
        customer = customerRepository.save(customer);
        System.out.println();
    }

    private Customer customerMapper(CustomerInputDto customerInputDto) {
        return Customer.builder()
                .name(customerInputDto.getName())
                .lastName(customerInputDto.getLastName())
                .address(customerInputDto.getAddress())
                .email(customerInputDto.getEmail())
                .birthday(customerInputDto.getBirthday())
                .build();
    }

}

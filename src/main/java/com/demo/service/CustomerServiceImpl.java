package com.demo.service;

import com.demo.dto.input.CustomerInputDto;
import com.demo.dto.output.CustomerOutputDto;
import com.demo.dto.output.CustomerPaginateDto;
import com.demo.model.Customer;
import com.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CustomerOutputDto> listCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> CustomerOutputDto.builder()
                        .name(customer.getName().toUpperCase())
                        .lastName(customer.getLastName().toUpperCase())
                        .address(customer.getAddress())
                        .email(customer.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerOutputDto> listActiveCustomers() {
        return customerRepository.findByActiveIsTrue()
                .stream()
                .map(customer -> CustomerOutputDto.builder()
                        .name(customer.getName().toUpperCase())
                        .lastName(customer.getLastName().toUpperCase())
                        .address(customer.getAddress())
                        .email(customer.getEmail())
                        .active(customer.getActive())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public CustomerPaginateDto listCustomersWithPagination(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Customer> customerPage  = customerRepository.findAll(pageable);
        return CustomerPaginateDto.builder()
                .totalPages(customerPage.getTotalPages())
                .totalItems(customerPage.getSize())
                .customers(customerPage.get()
                        .map(customer -> CustomerOutputDto.builder()
                                .name(customer.getName().toUpperCase())
                                .lastName(customer.getLastName().toUpperCase())
                                .address(customer.getAddress())
                                .email(customer.getEmail())
                                .active(customer.getActive())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    private List<CustomerOutputDto> listCustomersOld() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerOutputDto> customerDtoList = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerOutputDto customerOutputDto = CustomerOutputDto.builder()
                    .name(customer.getName())
                    .lastName(customer.getLastName())
                    .address(customer.getAddress())
                    .email(customer.getEmail())
                    .build();

            customerDtoList.add(customerOutputDto);

        }
        return customerDtoList;
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

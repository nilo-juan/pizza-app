package com.demo.dto.output;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
public class CustomerPaginateDto {

    private Integer totalPages;
    private Integer totalItems;
    private List<CustomerOutputDto> customers;
}

package com.demo.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerOutputDto {

    private String name;

    private String lastName;

    private String address;

    private String email;

    private Boolean active;

}

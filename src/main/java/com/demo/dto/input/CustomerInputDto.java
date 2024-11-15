package com.demo.dto.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class CustomerInputDto {

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    private String name;

    private String lastName;

    private String address;

    @Email(message = "El correo electrónico no es válido")
    private String email;

    private LocalDate birthday;

}

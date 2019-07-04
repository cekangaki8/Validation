package com.porsetech.learning.validation;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class Foo {

    @NotNull(message = "string variable should be provided")
    private String stringVariable;

    @Email(message = "Email provided should be valid")
    private String email;

}

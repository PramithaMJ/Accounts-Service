package com.pmj.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {

    @NotEmpty(message = "Name cannot be empty.")
    @Size(min = 5,max = 30,message = ("The length of the customer name should be between 5 and 30."))
    private String name;

    @NotEmpty(message = "Email address cannot be empty.")
    @Email(message = "Email address should be a valid value.")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits.")
    private String mobileNumber;

    private AccountsDTO accountsDTO;
}

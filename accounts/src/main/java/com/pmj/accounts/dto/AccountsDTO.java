package com.pmj.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountsDTO {

    @NotEmpty(message = "Name cannot be null or empty.")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits.")
    private Long accountNumber;

    @NotEmpty(message = "Account number cannot be null or empty.")
    private String accountType;

    @NotEmpty(message = "Branch address cannot be null or empty.")
    private String branchAddress;
}

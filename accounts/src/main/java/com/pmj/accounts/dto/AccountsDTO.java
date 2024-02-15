package com.pmj.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDTO {

    @NotEmpty(message = "Name cannot be null or empty.")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits.")
    @Schema(
            description = "Account Number of PMJ Bank account", example = "3454433243"
    )
    private Long accountNumber;

    @NotEmpty(message = "Account number cannot be null or empty.")
    @Schema(
            description = "Account type of PMJ Bank account", example = "Savings"
    )
    private String accountType;

    @NotEmpty(message = "Branch address cannot be null or empty.")
    @Schema(
            description = "PMJ Bank branch address", example = "123 NewYork"
    )
    private String branchAddress;
}

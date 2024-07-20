package Banking.EntitiesDto;

import Banking.Entities.Customer;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {


    @NotBlank(message = "Account number is mandatory")
    private String accountNumber;

    @NotNull(message = "Balance is mandatory")
    @Positive(message = "Balance must be a positive value")
    private Double balance;

     @NotNull(message = "Customer is mandatory")
    private CustomerDto customer; // Consider using customerId instead for DTO

    // Getters and Setters (Lombok will generate these)
}

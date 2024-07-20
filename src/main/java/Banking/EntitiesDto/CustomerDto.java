package Banking.EntitiesDto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
public class CustomerDto {

    private Long id;

    @NotNull
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

   @NotNull
   @NotBlank(message = "cant null email")
   @Email
    private String email;

    @NotNull
    @NotBlank(message = "cant null phoneNo")
    @NumberFormat
    private String phoneNumber;


  //  private List<AccountDto> accounts;

    // Getters and Setters
}

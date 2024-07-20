package Banking.Service;

import Banking.Entities.Customer;
import Banking.EntitiesDto.CustomerDto;

import java.util.Optional;

public interface CustomerS
{
    public CustomerDto CreateCustomer(CustomerDto customerDto);

    public Optional<CustomerDto> DelateCustomer(Long Customer_id);

    public Optional<CustomerDto> UpdateCustomer(Long Customer_id,CustomerDto customerDto);

   public Optional<CustomerDto> GetCustomer(Long customer_id);
}

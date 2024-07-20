package Banking.Serviceimple;

import Banking.Entities.Customer;
import Banking.EntitiesDto.CustomerDto;
import Banking.Repo.CustomeRepo;
import Banking.ResourceNotFoundException;
import Banking.Service.CustomerS;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerS_imple implements CustomerS
{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomeRepo customeRepo;
    @Override
    public CustomerDto CreateCustomer(CustomerDto customerDto)
    {
        Customer customerS1=this.modelMapper.map(customerDto, Customer.class);
        customeRepo.save(customerS1);
        CustomerDto c1= this.modelMapper.map(customerS1,CustomerDto.class);
        return  c1;

    }

    @Override
    public Optional<CustomerDto> DelateCustomer(Long Customer_id) {
        Optional<Customer> c1= Optional.ofNullable(this.customeRepo.findById(Customer_id).orElseThrow(() -> new ResourceNotFoundException("Customer not found")));
        this.customeRepo.deleteById(Customer_id);
        return Optional.ofNullable(this.modelMapper.map(c1, CustomerDto.class));
    }

    @Override
    public Optional<CustomerDto> UpdateCustomer(Long Customer_id, CustomerDto customerDto)
    {
        Optional<Customer> c1= Optional.ofNullable(this.customeRepo.findById(Customer_id).orElseThrow(() -> new ResourceNotFoundException("Customer not found")));
        if(c1.isPresent()) {
            Customer c2 = c1.get();
            c2.setName(customerDto.getName());
            c2.setPhoneNumber(customerDto.getPhoneNumber());
            c2.setEmail(customerDto.getEmail());
          Customer upc=  this.customeRepo.save(c2);
        CustomerDto upc2 = this.modelMapper.map(upc,CustomerDto.class);
          return Optional.of(upc2);
        }

        else
        {
            return Optional.empty();
        }

    }

    @Override
    public Optional<CustomerDto> GetCustomer(Long  customer_id) {
        Optional<CustomerDto> c1= Optional.ofNullable(this.modelMapper.map(this.customeRepo.findById(customer_id).
                orElseThrow(() -> new ResourceNotFoundException("Customer not found")), CustomerDto.class));
        return c1;

    }

}

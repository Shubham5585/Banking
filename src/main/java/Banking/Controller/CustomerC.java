package Banking.Controller;

import Banking.EntitiesDto.CustomerDto;
import Banking.Service.CustomerS;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/customer/")
public class CustomerC
{
    @Autowired
    private CustomerS customerS;
@GetMapping("data")
    public String getdata()
{
    return "hi Shubham";
}
@PostMapping("create/")
public ResponseEntity<CustomerDto> createcustomer(@Valid @RequestBody CustomerDto customerDto)
{
CustomerDto c1=this.customerS.CreateCustomer(customerDto);
return new ResponseEntity<>(c1, HttpStatus.CREATED);
}

    @PatchMapping("update/{customer_id}")
    public ResponseEntity<Optional<CustomerDto>> updatecustomer(@Valid @PathVariable("customer_id") long customer_id, @RequestBody CustomerDto customerDto)
    {
        Optional<CustomerDto> c1=this.customerS.UpdateCustomer(customer_id,customerDto);
        return new ResponseEntity<>(c1, HttpStatus.ACCEPTED);
    }

    @GetMapping("get/{customer_id}")
    public ResponseEntity<Optional<CustomerDto>> getcustomer(@Valid @PathVariable("customer_id") long customer_id)
    {
        Optional<CustomerDto> c1=this.customerS.GetCustomer(customer_id);
        return new ResponseEntity<>(c1, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{customer_id}")
    public ResponseEntity<Optional<CustomerDto>> deletecustomer(@Valid @PathVariable("customer_id") long customer_id)
    {
        Optional<CustomerDto> c1=this.customerS.DelateCustomer(customer_id);
        return new ResponseEntity<>(c1, HttpStatus.OK);
    }

}

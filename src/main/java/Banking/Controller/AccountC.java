package Banking.Controller;

import Banking.EntitiesDto.AccountDto;
import Banking.EntitiesDto.CustomerDto;
import Banking.Service.AccountS;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/account")

public class AccountC
{
    @Autowired
    private AccountS accountS;
    @GetMapping("data")
    public String getdata()
    {
        return "hi Shubham";
    }
    @PostMapping("create/")
    public ResponseEntity<AccountDto> createaccount(@Valid @RequestBody AccountDto accountDto)
    {
        AccountDto c1=this.accountS.CreateAccount(accountDto);
        return new ResponseEntity<>(c1, HttpStatus.CREATED);
    }

    @PatchMapping("update/{account_id}")
    public ResponseEntity<AccountDto> updateaccount(@Valid @PathVariable("account_id") Long account_id, @RequestBody AccountDto accountDto)
    {
        AccountDto c1=this.accountS.UpdateAccount(account_id,accountDto);
        return new ResponseEntity<>(c1, HttpStatus.ACCEPTED);
    }

    @GetMapping("get/{account_id}")
    public ResponseEntity<AccountDto> getaccount(@Valid @PathVariable("account_id") long account_id)
    {
        AccountDto c1=this.accountS.GetAccount(account_id);
        return new ResponseEntity<>(c1, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{account_id}")
    public ResponseEntity<AccountDto> deleteaccount(@Valid @PathVariable("account_id") long account_id)
    {
        AccountDto c1=this.accountS.DeleteAccount(account_id);
        return new ResponseEntity<>(c1, HttpStatus.OK);
    }

}


package Banking.Serviceimple;

import Banking.Entities.Account;
import Banking.EntitiesDto.AccountDto;
import Banking.Repo.AccountRepo;
import Banking.ResourceNotFoundException;
import Banking.Service.AccountS;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountS_imple implements AccountS
{
    @Autowired
    private AccountRepo accountrepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AccountDto CreateAccount(AccountDto accountDto)
    {
        Account a= this.modelMapper.map(accountDto,Account.class);
        this.accountrepo.save(a);
        return accountDto;
    }

    @Override
    public AccountDto DeleteAccount(Long Account_no)
    {
        AccountDto a=this.modelMapper.map(this.accountrepo.findById(Account_no).orElseThrow(()->new ResourceNotFoundException("resource not found")),AccountDto.class);
        this.accountrepo.deleteById(Account_no);
        return a;
    }

    @Override
    public AccountDto UpdateAccount(Long Account_no, AccountDto accountDto)
    {
        Account a= this.accountrepo.findById(Account_no).orElseThrow(()->new ResourceNotFoundException("Resource not found"));
        a.setAccountNumber(accountDto.getAccountNumber());
        a.setBalance(accountDto.getBalance());
        return this.modelMapper.map(a,AccountDto.class);

    }

    @Override
    public AccountDto GetAccount(Long Account_no) {
        return this.modelMapper.map(this.accountrepo.findById(Account_no).orElseThrow(()->new ResourceNotFoundException("resource not found")),AccountDto.class);

    }
}

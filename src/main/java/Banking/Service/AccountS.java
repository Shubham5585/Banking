package Banking.Service;

import Banking.EntitiesDto.AccountDto;

public interface AccountS
{
    public AccountDto CreateAccount(AccountDto accountDto);
    public AccountDto DeleteAccount(Long Account_no);
    public AccountDto UpdateAccount(Long Account_no,AccountDto accountDto);
    public AccountDto GetAccount(Long Account_no);



}

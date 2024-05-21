package uk.ac.bolton.boltonuniversitybankingapp.mapper;

import uk.ac.bolton.boltonuniversitybankingapp.dto.AccountDto;
import uk.ac.bolton.boltonuniversitybankingapp.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        return new Account(
                accountDto.getId(),
                accountDto.getAccountName(),
                accountDto.getBalance(),
                accountDto.getCreatedAt(),
                accountDto.getUpdatedAt()
        );
    }

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(
                account.getId(),
                account.getAccountName(),
                account.getBalance(),
                account.getCreatedAt(),
                account.getUpdatedAt()
        );
    }
}

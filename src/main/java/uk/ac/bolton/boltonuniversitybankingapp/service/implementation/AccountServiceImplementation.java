package uk.ac.bolton.boltonuniversitybankingapp.service.implementation;

import org.springframework.stereotype.Service;
import uk.ac.bolton.boltonuniversitybankingapp.dto.AccountDto;
import uk.ac.bolton.boltonuniversitybankingapp.entity.Account;
import uk.ac.bolton.boltonuniversitybankingapp.mapper.AccountMapper;
import uk.ac.bolton.boltonuniversitybankingapp.repository.AccountRepository;
import uk.ac.bolton.boltonuniversitybankingapp.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImplementation implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImplementation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);

        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }


    @Override
    public AccountDto getAccount(Long id) {

       Account account = accountRepository
               .findById(id)
               .orElseThrow(()-> new RuntimeException("There is no account associated with the supplied ID"));

       return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("There is no account associated with the supplied ID"));

        double totalBalance = account.getBalance() + amount;

        account.setBalance(totalBalance);

        Account updateAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(updateAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("There is no account associated with the supplied ID"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient balance");
        }

        double totalBalance = account.getBalance() - amount;

        account.setBalance(totalBalance);

        Account updateAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(updateAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("There is no account associated with the supplied ID"));

        accountRepository.delete(account);
    }
}


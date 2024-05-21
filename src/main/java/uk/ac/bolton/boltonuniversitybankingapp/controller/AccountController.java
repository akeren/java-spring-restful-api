package uk.ac.bolton.boltonuniversitybankingapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.bolton.boltonuniversitybankingapp.dto.AccountDto;
import uk.ac.bolton.boltonuniversitybankingapp.service.AccountService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccount(id);

        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposits")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {

        Double amount = request.get("amount");

       AccountDto accountDto =  accountService.deposit(id, amount);

        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraws")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");

        AccountDto accountDto =  accountService.withdraw(id, amount);

        return ResponseEntity.ok(accountDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);

        return ResponseEntity.ok("Account deleted successfully");
    }
}

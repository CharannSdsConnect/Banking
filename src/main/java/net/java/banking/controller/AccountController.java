package net.java.banking.controller;

import net.java.banking.dto.AccountDto;
import net.java.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public ResponseEntity<AccountDto> addAccount(AccountDto accountDto) {
        return new ResponseEntity<>(
                accountService.createAccount(accountDto),
                HttpStatus.CREATED
        );
    }
}

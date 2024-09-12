package net.java.banking.service.impl;

import net.java.banking.dto.AccountDto;
import net.java.banking.entity.Account;
import net.java.banking.mapper.AccountMapper;
import net.java.banking.repository.AccountRepository;
import net.java.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(
                ()-> new RuntimeException("Invalid id")
        );

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(
                        ()-> new RuntimeException("Invalid id")
                );
        account.setBalance(
                account.getBalance() + amount
        );

        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(
                        ()-> new RuntimeException("Invalid id")
                );
        if(account.getBalance() < amount) {
            throw new RuntimeException("Insufficient amount");
        }

        account.setBalance(
                account.getBalance() - amount
        );

        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map((account) ->
                        AccountMapper.mapToAccountDto(account))
                            .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(
                        ()-> new RuntimeException("Invalid id")
                );

        accountRepository.deleteById(id);
    }
}

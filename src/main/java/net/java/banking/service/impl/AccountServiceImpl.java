package net.java.banking.service.impl;

import net.java.banking.dto.AccountDto;
import net.java.banking.entity.Account;
import net.java.banking.mapper.AccountMapper;
import net.java.banking.repository.AccountRepository;
import net.java.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}

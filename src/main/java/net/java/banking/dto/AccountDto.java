package net.java.banking.dto;

import lombok.Data;

import java.security.PrivilegedAction;
@Data
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;

}

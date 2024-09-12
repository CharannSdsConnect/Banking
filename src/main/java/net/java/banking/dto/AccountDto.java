package net.java.banking.dto;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private long id;
    private String accountHolderName;
    private double balance;

}

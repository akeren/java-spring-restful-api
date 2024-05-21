package uk.ac.bolton.boltonuniversitybankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountName;
    private double balance;
    private Date createdAt;
    private Date updatedAt;
}

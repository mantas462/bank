package bank.dto.customer;

import bank.dto.account.AccountDto;
import bank.dto.card.CardDto;
import bank.entity.customer.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class CustomerDto {

    private BigInteger id;

    private String fullName;

    private CustomerType type;

    public List<CardDto> cards;

    public List<AccountDto> accounts;
}

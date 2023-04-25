package bank.util.mapper.customer;

import bank.dto.card.CardDto;
import bank.dto.customer.CustomerDto;
import bank.entity.customer.Customer;
import bank.util.mapper.account.AccountMapper;

import java.util.List;

public final class CustomerMapper {

    public static CustomerDto toDto(Customer customer, List<CardDto> cardDtoList) {

        return CustomerDto.builder()
                .id(customer.getId())
                .fullName(customer.getFullName())
                .type(customer.getType())
                .cards(cardDtoList)
                .accounts(customer.getAccounts().stream().map(AccountMapper::toDto).toList())
                .build();
    }
}

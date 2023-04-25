package bank.util.mapper.account;

import bank.dto.account.AccountDto;
import bank.entity.account.Account;

public final class AccountMapper {

    public static AccountDto toDto(Account account) {

        return AccountDto.builder()
                .id(account.getId())
                .value(account.getAccountDetails())
                .build();
    }
}

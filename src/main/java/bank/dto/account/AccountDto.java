package bank.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@AllArgsConstructor
@Data
@Builder
public class AccountDto {

    private BigInteger id;

    private String value;
}

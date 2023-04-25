package bank.dto.card;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@AllArgsConstructor
@Data
@Builder
public class CardDto {

    private BigInteger id;

    private String value;
}

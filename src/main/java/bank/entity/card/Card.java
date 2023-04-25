package bank.entity.card;

import bank.entity.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Timestamp;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    private BigInteger id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardType type;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private Timestamp expiry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Customer customer;

    public String getCardDetails() {

        StringBuilder builder = new StringBuilder();
        String encryptedCardNumber = getEncryptedCardNumber();
        return builder.append(encryptedCardNumber).append(" - ").append(type).toString();
    }

    private String getEncryptedCardNumber() {

        return "XXXX XXXX XXXX " + cardNumber.substring(15);
    }
}

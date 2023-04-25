package bank.entity.account;

import bank.entity.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    private BigInteger id;

    @Column(nullable = false)
    private String iban;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountCurrency currency;

    @Column(nullable = false)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Customer customer;

    public String getAccountDetails() {

        StringBuilder builder = new StringBuilder();
        return builder.append(iban).append(" - ").append(balance).append(" ").append(currency).toString();
    }
}

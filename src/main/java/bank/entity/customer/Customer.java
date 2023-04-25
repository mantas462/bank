package bank.entity.customer;

import bank.entity.account.Account;
import bank.entity.card.Card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private BigInteger id;

    @Column(nullable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerType type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    public List<Card> cards;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    public List<Account> accounts;
}

package bank.dao.card;

import bank.entity.card.Card;
import bank.entity.card.CardType;
import bank.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface CardDao extends JpaRepository<Card, BigInteger> {

    @Query(value = "SELECT a FROM Card a WHERE customer = ?1 AND type = ?2")
    List<Card> findByCustomerAndType(Customer customer, CardType type);
}

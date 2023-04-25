package bank.dao.customer;

import bank.entity.customer.Customer;
import bank.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer, BigInteger> {

    @Query(value = "SELECT a FROM Customer a WHERE id = ?1 AND type = ?2")
    Optional<Customer> findByIdAndType(BigInteger customerId, CustomerType customerType);
}

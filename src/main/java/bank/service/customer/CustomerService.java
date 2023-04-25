package bank.service.customer;

import bank.dao.customer.CustomerDao;
import bank.dto.card.CardDto;
import bank.dto.customer.CustomerDto;
import bank.entity.card.CardType;
import bank.entity.customer.Customer;
import bank.entity.customer.CustomerType;
import bank.service.card.CardService;
import bank.util.mapper.customer.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerDao customerDao;

    private CardService cardService;

    @Transactional(readOnly = true)
    public CustomerDto getByIdAndType(BigInteger id, CustomerType customerType) {

        Customer customer = customerDao.findByIdAndType(id, customerType).orElseThrow(() -> new NoSuchElementException("Customer with id=[%s] does not exist".formatted(id)));
        List<CardDto> cardList = cardService.findByCustomerAndCardType(customer, CardType.DEBIT);

        return CustomerMapper.toDto(customer, cardList);
    }
}

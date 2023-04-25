package bank.service.card;

import bank.dao.card.CardDao;
import bank.dto.card.CardDto;
import bank.entity.card.Card;
import bank.entity.card.CardType;
import bank.entity.customer.Customer;
import bank.util.mapper.card.CardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardService {

    private CardDao cardDao;

    public List<CardDto> findByCustomerAndCardType(Customer customer, CardType cardType) {

        List<Card> cards = cardDao.findByCustomerAndType(customer, cardType);

        return cards.stream().map(CardMapper::toDto).toList();
    }
}

package bank.util.mapper.card;

import bank.dto.card.CardDto;
import bank.entity.card.Card;

public final class CardMapper {

    public static CardDto toDto(Card card) {

        return CardDto.builder()
                .id(card.getId())
                .value(card.getCardDetails())
                .build();
    }
}

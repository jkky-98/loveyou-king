package jkky98.king;

import jakarta.annotation.PostConstruct;
import jkky98.king.domain.card.CardRank;
import jkky98.king.domain.card.CardRankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final CardRankRepository cardRankRepository;

    @PostConstruct
    public void init() {
        CardRank cardRank = new CardRank();
        cardRank.setHighLevel(10);
        cardRank.setUserName("주인장");
        cardRank.setContribution(5000);
        cardRank.setCount(5);
        cardRankRepository.save(cardRank);
    }
}

package jkky98.king.domain.card;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CardRankRepository {

    private static final Map<String, CardRank> store = new HashMap<>();
    private static long sequence = 0L;

    public CardRank save(CardRank cardRank) {
        cardRank.setId(++sequence);
        store.put(cardRank.getUserName(), cardRank);
        return cardRank;
    }

    public CardRank findByUsername(String username) {
        return store.get(username);
    }

    public List<CardRank> findAll() {
        return new ArrayList<>(store.values());
    }
}

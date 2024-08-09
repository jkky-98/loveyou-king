package jkky98.king.domain.king;

import jkky98.king.domain.card.CardRank;
import jkky98.king.domain.card.CardRankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KingService {
    private final King king;
    private final CardRankRepository cardRankRepository;

    public void updateKingStatus() {
        List<CardRank> allSlavers = cardRankRepository.findAll();

        Integer sum = 0;
        for (CardRank allSlaver : allSlavers) {
            sum += allSlaver.getContribution();
        }

        king.setExp(sum);

    }
}

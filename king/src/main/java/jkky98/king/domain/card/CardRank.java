package jkky98.king.domain.card;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CardRank {

    private Long id;

    private String userName;

    private Integer highLevel;

}

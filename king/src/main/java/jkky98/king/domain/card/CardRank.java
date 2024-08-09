package jkky98.king.domain.card;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CardRank {

    private Long id = 0L;

    private String userName = "";

    private Integer highLevel = 0;

    private Integer contribution = 0;

    private Integer count = 0;

}

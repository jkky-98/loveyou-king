package jkky98.king.domain.card;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaveCardForm {

    @NotNull
    private String userName;

    @NotNull
    private Integer highLevel;

}

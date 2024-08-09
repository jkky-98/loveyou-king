package jkky98.king.domain.card;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaveCardForm {

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    private Integer level;

}

package jkky98.king.web.card.form;


import jkky98.king.domain.card.CardRank;
import jkky98.king.domain.card.SaveCardForm;
import jkky98.king.domain.card.CardRankRepository;
import jkky98.king.domain.king.KingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/king/king-card")
@RequiredArgsConstructor
public class FormGameController {

    private final CardRankRepository cardRankRepository;
    private final KingService kingService;

    @GetMapping
    public String AddForm(@ModelAttribute SaveCardForm saveCardForm) {
        return "card/game-cm";
    }

    @GetMapping("/ranks")
    public String findAll(Model model) {
        List<CardRank> cardGameRankSlavers = cardRankRepository.findAll();
        model.addAttribute("cardGameRankSlavers", cardGameRankSlavers);
        return "card/ranks";
    }

    @PostMapping
    public String save(@Validated @ModelAttribute SaveCardForm saveCardForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> globalErrors = bindingResult.getGlobalErrors();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            System.out.println("globalErrors = " + globalErrors);
            System.out.println("fieldErrors = " + fieldErrors);
            return "redirect:/king";
        }

        CardRank cardRank = cardRankRepository.findByUsername(saveCardForm.getUserName());
        if (cardRank == null) {
            CardRank cardRankNew = new CardRank();
            cardRankNew.setCount(1);
            cardRankNew.setHighLevel(saveCardForm.getLevel());
            cardRankNew.setUserName(saveCardForm.getUserName());
            cardRankNew.setContribution(saveCardForm.getLevel() * 10);
            cardRankRepository.save(cardRankNew);

        } else {
            cardRank.setCount(cardRank.getCount() + 1);
            cardRank.setContribution(cardRank.getContribution() + saveCardForm.getLevel() * 10);
            if (cardRank.getHighLevel() < saveCardForm.getLevel()) {
                cardRank.setHighLevel(saveCardForm.getLevel());
            }
        }
        System.out.println("cardRankRepository.findAll() = " + cardRankRepository.findAll());

        kingService.updateKingStatus();

        return "redirect:/king";
    }
}

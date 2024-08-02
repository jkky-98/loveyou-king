package jkky98.king.web.card.form;


import jkky98.king.domain.card.CardRank;
import jkky98.king.domain.card.SaveCardForm;
import jkky98.king.domain.card.CardRankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/king")
@RequiredArgsConstructor
public class FormGameController {

    private final CardRankRepository cardRankRepository;

    @GetMapping("/king-card")
    public String AddForm(@ModelAttribute SaveCardForm saveCardForm ) {
        return "card/game-cm";
    }

    @GetMapping()
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/king-card/ranks")
    public String findAll(Model model) {
        List<CardRank> allRank = cardRankRepository.findAll();
        model.addAttribute("ranks", allRank);
        return "card/ranks";
    }

    @PostMapping("/king-card")
    public String save(@Validated @ModelAttribute SaveCardForm saveCardForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // TODO
            log.info("이거 탐????");
            return "index";
        }
        CardRank cardRank = new CardRank();
        cardRank.setHighLevel(saveCardForm.getHighLevel());
        cardRank.setUserName(saveCardForm.getUserName());

        cardRankRepository.save(cardRank);
        log.info(String.valueOf(cardRank));
        return "redirect:/king";
    }
}

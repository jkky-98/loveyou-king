package jkky98.king.web.form;


import jkky98.king.domain.card.CardRank;
import jkky98.king.domain.card.CardRankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/king")
@RequiredArgsConstructor
public class FormGameController {

    private final CardRankRepository cardRankRepository;

    @GetMapping("/king-card")
    public String AddForm(Model model) {
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
}

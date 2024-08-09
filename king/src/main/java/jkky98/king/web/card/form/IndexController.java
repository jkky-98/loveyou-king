package jkky98.king.web.card.form;

import jkky98.king.domain.card.CardRankRepository;
import jkky98.king.domain.king.King;
import jkky98.king.domain.king.KingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/king")
public class IndexController {
    private final CardRankRepository cardRankRepository;
    private final KingService kingService;
    private final King king;

    @GetMapping
    public String viewFormIndex(Model model) {
        kingService.updateKingStatus();
        model.addAttribute("king", king);
        System.out.println("king.getExp() = " + king.getExp());
        return "index";
    }
}

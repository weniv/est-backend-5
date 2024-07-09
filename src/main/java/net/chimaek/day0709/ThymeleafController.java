package net.chimaek.day0709;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("name1", "굿굿베리굿");

        return "index";
    }
}
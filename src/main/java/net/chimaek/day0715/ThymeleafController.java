package net.chimaek.day0715;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public String index(Model model) {
        User max = new User("max", "max@gmail.com", false);

        model.addAttribute("user", max);
        return "index";
    }
}
package net.chimaek.day0715;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public String index(@RequestParam("name") String name, Model model) {
        model.addAttribute("name1", name);
        return "index";
    }
}
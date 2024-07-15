package net.chimaek.day0715;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public String index(Model model) {
        User max = new User("max", "max@gmail.com", false, false);
        int[] iterData = {1, 2, 3, 4, 5};

        model.addAttribute("user", max);
        model.addAttribute("iterData", iterData);

        return "index";
    }
    @GetMapping("/index/2")
    public String index2(Model model){
        return "index2";
    }

    @GetMapping("/index/3")
    public String index3(Model model){
        return "index3";
    }
}
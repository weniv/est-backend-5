package net.chimaek.day0715;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public String index(Model model) {
        User max = new User("max", "max@gmail.com", false, false,"max2");
        int[] iterData = {1, 2, 3, 4, 5};

        model.addAttribute("user", max);
        model.addAttribute("iterData", iterData);

        return "index";
    }

    @GetMapping("/index/2")
    public String index2(Model model) {
        return "index2";
    }

    @GetMapping("/index/3")
    public String index3(Model model) {
        return "index3";
    }

    @PostMapping("/users")
    public String users(@ModelAttribute User user) {

        System.out.println("유저의 이름은" + user.getName() + "입니다.");
        System.out.println("유저의 이메일은" + user.getEmail() + "입니다.");

        return "index2";
    }


}
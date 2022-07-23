package libratum.unit5.forum.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Account {

    @RequestMapping(value = "/registration")
    public String account() {
        
        return "account/registration";
    }

    @PostMapping(value = "/registration/signup")
    public String signUp() {
        return "redirect:/";
    }

    @PostMapping(value = "/registration/login")
    public String login() {
        return "redirect:/";
    }

    @RequestMapping(value = "/account")
    public String registration() {
        return "account/account";
    }
}

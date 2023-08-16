package com.cielazure.board.Controller;

import com.cielazure.board.Model.User;
import com.cielazure.board.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    private String Login() {
        return "account/login";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.join(user);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "account/register";
    }


}

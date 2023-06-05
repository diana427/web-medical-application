package com.example.webmedicalapplication.controllers;

import com.example.webmedicalapplication.models.Account;
import com.example.webmedicalapplication.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {
    @Autowired
    private AccountService accountService;

    // register new account
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    // saving new account
    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute Account account) {
        accountService.save(account);

        return "redirect:/";
    }
}

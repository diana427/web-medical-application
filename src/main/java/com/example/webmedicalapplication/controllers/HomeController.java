package com.example.webmedicalapplication.controllers;

import com.example.webmedicalapplication.models.Card;
import com.example.webmedicalapplication.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CardService cardService;

    // home page
    @GetMapping("/")
    // getting data by specific keyword
    public String home(Model model, @Param("keyword") String keyword) {
        List<Card> cards = cardService.getAll(keyword);
        model.addAttribute("cards", cards);
        model.addAttribute("keyword", keyword);

        return "home";
    }
}

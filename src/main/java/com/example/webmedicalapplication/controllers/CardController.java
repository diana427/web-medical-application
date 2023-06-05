package com.example.webmedicalapplication.controllers;

import com.example.webmedicalapplication.models.Account;
import com.example.webmedicalapplication.models.Card;
import com.example.webmedicalapplication.services.AccountService;
import com.example.webmedicalapplication.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private AccountService accountService;

    // showing data into the page
    @GetMapping("/cards/{id}")
    public String getCard(@PathVariable Long id, Model model) {
        Optional<Card> optionalCard = cardService.getById(id);
        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();
            model.addAttribute("card", card);
            return "card";
        } else { // if post isn`t found
            return "404";
        }
    }

    // create new card
    @GetMapping("/cards/new")
    public String creatNewCard(Model model) {
        Optional<Account> optionalAccount = accountService.findUserByEmail("mariaDoctor@gmail.com");
        if (optionalAccount.isPresent()) {
            Card card = new Card();
            card.setAccount(optionalAccount.get());
            model.addAttribute("card", card);
            return "card_new";
        } else {
            return "404";
        }
    }

    // save new card
    @PostMapping("/cards/new")
    public String saveNewPost(@ModelAttribute Card card) {
        cardService.save(card);
        return "redirect:/cards/" + card.getId();
    }

    // new card for TCCC
    @GetMapping("/cards/new/tacmed")
    public String creatNewCardTacMed(Model model) {
        Optional<Account> optionalAccount = accountService.findUserByEmail("mariaDoctor@gmail.com");
        if (optionalAccount.isPresent()) {
            Card card = new Card();
            card.setAccount(optionalAccount.get());
            model.addAttribute("card", card);
            return "card_new_tacmed";
        } else {
            return "404";
        }
    }

    // save card
    @PostMapping("/cards/new/tacmed")
    public String saveNewPostTacMed(@ModelAttribute Card card) {
        cardService.save(card);
        return "redirect:/cards/" + card.getId();
    }

    // editing specific card
    @GetMapping("/cards/{id}/edit")
    @PreAuthorize("isAuthenticated()")
    public String getCardForEdit(@PathVariable Long id, Model model) {

        // find post by id
        Optional<Card> optionalCard = cardService.getById(id);
        // if post exist put it in model
        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();
            model.addAttribute("card", card);
            return "card_edit";
        } else {
            return "404";
        }
    }

    // save changes
    @PostMapping("/cards/{id}")
    @PreAuthorize("isAuthenticated()")
    public String updateCard(@PathVariable Long id, Card card, BindingResult result, Model model) {
        Optional<Card> optionalCard = cardService.getById(id);
         if (optionalCard.isPresent()) {
             Card existingCard = optionalCard.get();

             existingCard.setLastName(card.getLastName());
             existingCard.setFirstName(card.getFirstName());
             existingCard.setAge(card.getAge());
             existingCard.setCity(card.getCity());
             existingCard.setEmail(card.getEmail());
             existingCard.setPhoneNumber(card.getPhoneNumber());
             existingCard.setProblemList(card.getProblemList());
             existingCard.setMedications(card.getMedications());

             cardService.save(existingCard);
         }

         return "redirect:/cards/" + card.getId();
    }

    // delete existing card
    @GetMapping("/cards/{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCard(@PathVariable Long id) {

        // find post by id
        Optional<Card> optionalCard = cardService.getById(id);
        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();

            cardService.delete(card);
            return "redirect:/";
        } else {
            return "404";
        }
    }
}

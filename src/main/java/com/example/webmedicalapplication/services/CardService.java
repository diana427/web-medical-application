package com.example.webmedicalapplication.services;

import com.example.webmedicalapplication.models.Card;
import com.example.webmedicalapplication.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Optional<Card> getById(Long id) {

        return cardRepository.findById(id);
    }

    // sorting data with keyword
    public List<Card> getAll(String keyword) {
        if(keyword != null) {
            return cardRepository.findAll(keyword);
        }

        return cardRepository.findAll();
    }

    // saving card with current data and time
    public Card save(Card card) {
        if (card.getId() == null) {
            card.setCreatedAtDate(LocalDate.now());
            card.setCreatedAtTime(LocalTime.now());
        }
        card.setUpdatedAtDate(LocalDate.now());
        card.setUpdatedAtTime(LocalTime.now());
        return cardRepository.save(card);
    }

    public void delete(Card card) {
        cardRepository.delete(card);
    }
}
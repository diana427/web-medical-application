package com.example.webmedicalapplication.repositories;

import com.example.webmedicalapplication.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    // sorting data using keyword
    @Query("SELECT p FROM Card p WHERE p.lastName LIKE %?1%"
    + "OR p.firstName LIKE %?1%"
    + "OR p.city LIKE %?1%"
    + "OR p.email LIKE %?1%"
    + "OR p.gender LIKE %?1%"
    + "OR CONCAT(p.age, '') LIKE %?1%")
    public List<Card> findAll(String keyword);

}

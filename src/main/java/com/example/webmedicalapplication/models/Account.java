package com.example.webmedicalapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String password;
    private String firstName;
    private String lastName;
    private String email;


    // one account can have many cards
    @OneToMany(mappedBy = "account")
    private List<Card> cards;

    // many account can have many authorities
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
    joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    private Set<Authority> authorities = new HashSet<>();

    @Override
    public String toString() {
        return "Account{" +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}

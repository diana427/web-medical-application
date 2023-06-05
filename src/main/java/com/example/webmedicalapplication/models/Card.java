package com.example.webmedicalapplication.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String lastName;
    private String firstName;
    private Integer age;
    private Long privateNumber;
    private String kindOfInjury;
    private String gender;
    private Long phoneNumber;
    private String email;
    private String city;
    @Lob
    @Column(name="Problem List", columnDefinition = "CLOB")
    private String problemList;
    @Lob
    @Column(name="Medications", columnDefinition = "CLOB")
    private String medications;
    private LocalDate createdAtDate;
    private LocalTime createdAtTime;
    private LocalDate updatedAtDate;
    private LocalTime updatedAtTime;

    @NotNull
    // many cards can be connected only to one account
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", IdNumber=" + privateNumber +
                ", kindOfInjury='" + kindOfInjury + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", problemList='" + problemList + '\'' +
                ", medications='" + medications + '\'' +
                ", createdAtDate=" + createdAtDate +
                ", createdAtTime=" + createdAtTime +
                ", updatedAt=" + updatedAtDate +
                ", updatedAtTime=" + updatedAtTime +
                '}';
    }
}

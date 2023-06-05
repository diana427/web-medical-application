package com.example.webmedicalapplication.services;
import com.example.webmedicalapplication.models.Account;
import com.example.webmedicalapplication.models.Authority;
import com.example.webmedicalapplication.repositories.AccountRepository;
import com.example.webmedicalapplication.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AuthorityRepository authorityRepository;

    public Account save(Account account) {

        if (account.getId() == null) {
            if (account.getAuthorities().isEmpty()) {
                Set<Authority> authorities = new HashSet<>();
                authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities::add);
                account.setAuthorities(authorities);
            }
        }

        // encryption of password
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    public Optional<Account> findUserByEmail(String email) {
        return accountRepository.findUserByEmail(email);
    }
}
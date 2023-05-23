package com.example.webmedicalapplication.repositories;

import com.example.webmedicalapplication.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.lastName LIKE %?1%"
    + "OR p.firstName LIKE %?1%"
    + "OR p.city LIKE %?1%"
    + "OR p.email LIKE %?1%"
    + "OR p.gender LIKE %?1%"
    + "OR CONCAT(p.age, '') LIKE %?1%")
    public List<Post> findAll(String keyword);

}

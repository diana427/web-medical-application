package com.example.webmedicalapplication.services;

import com.example.webmedicalapplication.models.Post;
import com.example.webmedicalapplication.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.List;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Optional<Post> getById(Long id) {

        return postRepository.findById(id);
    }

    public List<Post> getAll(String keyword) {
        if(keyword != null) {
            return postRepository.findAll(keyword);
        }

        return postRepository.findAll();
    }

    public Post save(Post post) {
        if (post.getId() == null) {
            post.setCreatedAtDate(LocalDate.now());
            post.setCreatedAtTime(LocalTime.now());
        }
        post.setUpdatedAtDate(LocalDate.now());
        post.setUpdatedAtTime(LocalTime.now());
        return postRepository.save(post);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

}

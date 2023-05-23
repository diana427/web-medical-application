package com.example.webmedicalapplication.controllers;

import com.example.webmedicalapplication.models.Account;
import com.example.webmedicalapplication.models.Post;
import com.example.webmedicalapplication.services.AccountService;
import com.example.webmedicalapplication.services.PostService;
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
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    /*
     CREATE     -    POST /posts/{id} + requestBody
     READ       -    GET    /posts
     READ specific  - GET /posts/{id}
     UPDATE     -    PUT /posts/{id} + requestBody
     DELETE     -    DELETE /posts/{id}
  */
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        // looking for the post by id
        Optional<Post> optionalPost = postService.getById(id);
        // if the post exists, then shove it into the model
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post";
        } else { // if post isn`t found
            return "404";
        }
    }

    @GetMapping("/posts/new")
    public String creatNewPost(Model model) {
        Optional<Account> optionalAccount = accountService.findByEmail("mariaDoctor@gmail.com");
        if (optionalAccount.isPresent()) {
            Post post = new Post();
            post.setAccount(optionalAccount.get());
            model.addAttribute("post", post);
            return "post_new";
        } else {
            return "404";
        }
    }

    @PostMapping("/posts/new")
    public String saveNewPost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/new/tacmed")
    public String creatNewPostTacMed(Model model) {
        Optional<Account> optionalAccount = accountService.findByEmail("mariaDoctor@gmail.com");
        if (optionalAccount.isPresent()) {
            Post post = new Post();
            post.setAccount(optionalAccount.get());
            model.addAttribute("post", post);
            return "post_new_tacmed";
        } else {
            return "404";
        }
    }

    @PostMapping("/posts/new/tacmed")
    public String saveNewPostTacMed(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/{id}/edit")
    @PreAuthorize("isAuthenticated()")
    public String getPostForEdit(@PathVariable Long id, Model model) {

        // find post by id
        Optional<Post> optionalPost = postService.getById(id);
        // if post exist put it in model
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post_edit";
        } else {
            return "404";
        }
    }

    @PostMapping("/posts/{id}")
    @PreAuthorize("isAuthenticated()")
    public String updatePost(@PathVariable Long id, Post post, BindingResult result, Model model) {
        Optional<Post> optionalPost = postService.getById(id);
         if (optionalPost.isPresent()) {
             Post existingPost = optionalPost.get();

             existingPost.setLastName(post.getLastName());
             existingPost.setFirstName(post.getFirstName());
             existingPost.setAge(post.getAge());
             existingPost.setPhoneNumber(post.getPhoneNumber());
             existingPost.setProblemList(post.getProblemList());
             existingPost.setMedications(post.getMedications());

             postService.save(existingPost);
         }

         return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletePost(@PathVariable Long id) {

        // find post by id
        Optional<Post> optionalPost = postService.getById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            postService.delete(post);
            return "redirect:/";
        } else {
            return "404";
        }
    }
}

package com.example.webmedicalapplication.controllers;

import com.example.webmedicalapplication.models.Post;
import com.example.webmedicalapplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;


    @GetMapping("/")
    public String home(Model model, @Param("keyword") String keyword) {
        List<Post> posts = postService.getAll(keyword);
//        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        model.addAttribute("keyword", keyword);

        return "home";
    }

}

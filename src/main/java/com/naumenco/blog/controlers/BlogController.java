package com.naumenco.blog.controlers;

import com.naumenco.blog.models.Post;
import com.naumenco.blog.ropository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogHome(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "pages/blog";
    }

    @GetMapping("/blog/add")
    public String addBlog(Model model) {

        return "pages/add-blog";
    }

    @PostMapping("/blog/add")
    public String addBlog(@RequestParam String title, @RequestParam String anons, @RequestParam String fullText) {
        Post post = new Post(title, anons, fullText);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/detail/{id}")
    public String detail(@PathVariable(value = "id") long ID, Model model) {
        if (!postRepository.existsById(ID)) return "redirect:/blog";

        Optional<Post> post = postRepository.findById(ID);
        post.ifPresent(post1 -> model.addAttribute("post", post1));
        return "pages/detail";
    }

    @GetMapping("/blog/edite/{id}")
    public String editePost(@PathVariable long id, Model model) {
//       Post post =  postRepository.findById(id).orElseThrow();
        if (!postRepository.existsById(id)) return "redirect:/blog";
        Post post = postRepository.findById(id).orElseThrow();
        model.addAttribute("post", post);
        return "pages/edite";
    }

    @PostMapping("/blog/edite/{id}")
    public String editePost(@PathVariable long id, @RequestParam String title, @RequestParam String anons, @RequestParam String fullText) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullText(fullText);
        postRepository.save(post);
        return "redirect:/blog/detail/" + id;
    }

}

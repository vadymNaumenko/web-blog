package com.naumenco.blog.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("title","over list");
        return"home";
    }

    @GetMapping("/about")
    public String about(Model model){
       model.addAttribute("about","My company from Lutsk, this company is very good ");
        return "about";
    }
}

package com.naumenco.blog.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/widgets")
public class WidgetsController {

    @GetMapping("/wetter")
    public String wetter(){
        return "widgets/wetter";
    }

}

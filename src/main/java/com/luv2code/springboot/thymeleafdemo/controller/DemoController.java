package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    // create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model theModel) {

        theModel.addAttribute("theDate", new java.util.Date());

        return "helloworld";
        // Since we have Thymeleaf dependency in Maven POM file, Spring Boot will auto-configure to use Thymeleaf,
        // So when we return "helloworld", it will look in src/main/resources/templates/helloworld.html.
    }
}

package com.example.reportsystem.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

    @RequestMapping("/home")
    public String home(Authentication auth) {
        System.out.println("auth = " + auth);
        return "base/home";
    }

    @RequestMapping({"/", "/login"})
    public String login(Authentication auth) {
        System.out.println("auth = " + auth);
        return "base/login";
    }
}

package com.example.reportsystem.controller;

import com.example.reportsystem.common.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StartController {

    @Autowired
    private CommonService commonService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping({"/", "/login"})
    public String login(HttpServletRequest request, Authentication auth) {
        if(commonService.isAuthenticated(request, auth)) return "redirect:/home";
        return "redirect:/logIn";
    }

    @RequestMapping("/logIn")
    public String log_in() {
        return "/base/login";
    }

    @RequestMapping("/home")
    public String home(HttpServletRequest request, Authentication auth) {
        if(commonService.isAuthenticated(request, auth)) return "base/home";
        return "redirect:/logIn";
    }

    @PostMapping("/loginProcess")
    public String login_process() {
        return "redirect:/home";
    }
}

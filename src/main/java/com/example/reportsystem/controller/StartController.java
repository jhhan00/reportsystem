package com.example.reportsystem.controller;

import com.example.reportsystem.common.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

    @Autowired
    private CommonService commonService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/home")
    public String home(Authentication auth) {
        if(commonService.isAuthenticated(auth))
            return "base/home";
        else
            return "redirect:/login";
    }

    @RequestMapping({"/", "/login"})
    public String login(Authentication auth) {
        if(commonService.isAuthenticated(auth)) return "base/home";
        else return "redirect:/login";
    }
}

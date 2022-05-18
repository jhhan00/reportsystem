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

    private final CommonService commonService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public StartController(CommonService commonService) {
        this.commonService = commonService;
    }

    @RequestMapping("/")
    public String login(HttpServletRequest request, Authentication auth) {
        logger.info("/ , 가장 기본이 되는 페이지 & 로그인 이후");
        if(commonService.isAuthenticated(request, auth)) return "base/home";
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String log_in(HttpServletRequest request, Authentication auth) {
        logger.info("log_in , 로그인이 필요할 경우");
        if(commonService.isAuthenticated(request, auth)) return "redirect:/";
        return "/base/login";
    }

}

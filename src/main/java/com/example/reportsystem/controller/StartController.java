package com.example.reportsystem.controller;

import com.example.reportsystem.Service.CommonService;
import com.example.reportsystem.handler.SessionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StartController {

    private final CommonService commonService;
    private final SessionHandler sessionHandler;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public StartController(CommonService commonService, SessionHandler sessionHandler) {
        this.commonService = commonService;
        this.sessionHandler = sessionHandler;
    }

    @RequestMapping("/")
    public String login(Authentication auth) {
        logger.info("/ , 가장 기본이 되는 페이지 & 로그인 이후");
        if(sessionHandler.isLogin(auth)) return "base/home";
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String log_in(Authentication auth) {
        logger.info("log_in , 로그인이 필요할 경우");
        if(sessionHandler.isLogin(auth)) return "redirect:/";
        return "/base/login";
    }

    @RequestMapping("/main")
    public String report_main(HttpServletRequest request, Authentication auth) {
        logger.info("report_main , 로그인 후 리포트 페이지로 이동");
        if(sessionHandler.isAuthenticated(request)) return "report/report_main";
        return "redirect:/login";
    }
}

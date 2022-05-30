package com.example.reportsystem.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class MyLoginSuccessHandler implements AuthenticationSuccessHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("login success");

        String id = request.getParameter("username");
        String pw = request.getParameter("password");
        logger.info("id = " + id + " , pw = " + pw);

        sessionRemoveAttribute(request);

        response.sendRedirect("/");
    }

    public void sessionRemoveAttribute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);    // 이전에 로그인 실패한 이력이 있다면 session에서 실패 이력 제거
        }
    }
}

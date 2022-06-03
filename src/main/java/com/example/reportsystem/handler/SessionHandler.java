package com.example.reportsystem.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Component
public class SessionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 로그인 여부 - 로그인 되었는지 안되었는지 확인
     * @param authentication
     * @return
     */
    public boolean isLogin(Authentication authentication) {
        if(authentication != null) {
            logger.info("authentication.getAuthorities = " + authentication.getAuthorities());
            logger.info("authentication.getDetails     = " + authentication.getDetails());
            logger.info("authentication.getName        = " + authentication.getName());
            logger.info("authentication.getPrincipal   = " + authentication.getPrincipal());
            logger.info("authentication.getCredentials = " + authentication.getCredentials());
        }
        return authentication != null;
    }

    /**
     * 인증 여부 - 세션아이디가 등록되었는지 확인
     * @param request
     * @return
     */
    public boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = session.getId();

        return session.getAttribute(sessionId) != null;
    }

}

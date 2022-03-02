package com.example.reportsystem.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class CommonService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean isAuthenticated(HttpServletRequest request, Authentication auth) {
        HttpSession httpSession = request.getSession();
        logger.info("auth = " + auth);

        return auth != null;
    }
}

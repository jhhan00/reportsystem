package com.example.reportsystem.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Service
public class CommonService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean isAuthenticated(HttpServletRequest request, Authentication auth) {
        HttpSession httpSession = request.getSession();
        Enumeration<String> keys = httpSession.getAttributeNames();
        while(keys.hasMoreElements()) {
            String key = keys.nextElement();
            logger.info(key + " => " + httpSession.getAttribute(key));
            if(key.equals("SPRING_SECURITY_CONTEXT")) {
                SecurityContextImpl attribute = (SecurityContextImpl)httpSession.getAttribute(key);
                UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken)attribute.getAuthentication();
                logger.info("upat.getPrincipal   = " + upat.getPrincipal());
//                logger.info("upat.getName        = " + upat.getName());
//                logger.info("upat.getCredentials = " + upat.getCredentials());
//                logger.info("upat.getAuthorities = " + upat.getAuthorities());
//                logger.info("upat.getDetails     = " + upat.getDetails());

                WebAuthenticationDetails wad = (WebAuthenticationDetails)upat.getDetails();
                logger.info("wad.getSessionId = " + wad.getSessionId());

                User user = (User)upat.getPrincipal();
                logger.info("user.getUsername    = " + user.getUsername());
                logger.info("user.getPassword    = " + user.getPassword());
                logger.info("user.getAuthorities = " + user.getAuthorities());
            }
        }
        logger.info("auth = " + auth);

        return auth != null;
    }
}

package com.example.reportsystem.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean isAuthenticated(Authentication auth) {
        logger.info("auth = " + auth);

        return auth != null;
    }
}

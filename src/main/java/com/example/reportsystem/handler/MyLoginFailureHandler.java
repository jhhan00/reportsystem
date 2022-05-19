package com.example.reportsystem.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyLoginFailureHandler implements AuthenticationFailureHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("login fail");

//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("status_code", 401);
//        responseMap.put("exception", exception.getMessage());
//
//        response.getOutputStream().println(objectMapper.writeValueAsString(responseMap));
//        request.getRequestDispatcher("/login?error=true").forward(request, response);
        String id = request.getParameter("username");
        String pw = request.getParameter("password");
        logger.info("id = " + id + " , pw = " + pw);

        response.sendRedirect("/login?error=true");
    }
}

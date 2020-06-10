package org.launchcode.capstone;

import org.launchcode.capstone.controllers.AuthenticationController;
import org.launchcode.capstone.models.User;
import org.launchcode.capstone.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    //private static final List<String> adminWhiteList = Arrays.asList("/index", "/login", "/search", "/logout", "/css","/register");
    //private static final List<String> agentWhiteList = Arrays.asList("/index", "/login", "/agentsearch", "/logout", "/css", "/register");
    private static final List<String> whiteList = Arrays.asList("/", "/login", "/customer", "/logout", "/css", "/register");

    private static boolean isWhiteListed(String path) {
        for(String pathRoot : whiteList) {
            if (path.startsWith(pathRoot)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {
        if (isWhiteListed(request.getRequestURI())) {
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        if (user != null) {
            return true;
        }

        response.sendRedirect("");
        return false;
    }

}

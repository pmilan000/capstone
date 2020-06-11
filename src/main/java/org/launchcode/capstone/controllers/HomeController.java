package org.launchcode.capstone.controllers;

import org.launchcode.capstone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    AuthenticationController authenticationController;

    @GetMapping("/home")
    public String index(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("isloggedIn", (user != null));
        model.addAttribute("title", "Comcast Business: New Customer Depot" );

        if(user != null) {
            model.addAttribute("username", user.getUsername());
        }
        return "home";
    }

}

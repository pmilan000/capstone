package org.launchcode.capstone.controllers;

import org.launchcode.capstone.models.Customer;
import org.launchcode.capstone.models.CustomerDetails;
import org.launchcode.capstone.models.User;
import org.launchcode.capstone.models.data.CustomerDetailsRepository;
import org.launchcode.capstone.models.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CustomerProfileController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    @GetMapping("/profile")
    public String renderCreateDetailsForm(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("isloggedIn", (user != null));
        model.addAttribute("username", user.getUsername());
        model.addAttribute("title", "Edit Profile");
        model.addAttribute(new CustomerDetails());
        return "profile";

    }
    @PostMapping("/profile")
    public String processCustomerProfile (@ModelAttribute @Valid CustomerDetails customerDetails, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Customer profile");
            model.addAttribute("serviceAddress", customerDetails.getServiceAddress());
            model.addAttribute("phone", customerDetails.getPhone());
            model.addAttribute("email", customerDetails.getEmail());
            return "profile";
        }

        customerDetailsRepository.save(customerDetails);
        return "redirect:/profile";
    }

    @GetMapping("/edit")
    public String displayEditProfile(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("isloggedIn", (user != null));
        model.addAttribute("username", user.getUsername());
        model.addAttribute("title", "Edit Profile");
        model.addAttribute(new CustomerDetails());
        model.addAttribute("customers", customerRepository.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String processEditProfileForm(@ModelAttribute @Valid CustomerDetails newCustomerDetails,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Profile");
            model.addAttribute("address", "serviceAddress");
            model.addAttribute("phone", "phone");
            model.addAttribute("email", "email");
            return "edit";
        }

        customerDetailsRepository.save(newCustomerDetails);
        return "redirect:/profile";
    }

}

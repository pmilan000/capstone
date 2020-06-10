package org.launchcode.capstone.controllers;

import org.launchcode.capstone.models.CustomerDetails;
import org.launchcode.capstone.models.data.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class CustomerProfileController {

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @GetMapping("profile")
    public String renderCreateEventCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute(new CustomerDetails());
        return "customer/profile";

    }
    @PostMapping("profile")
    public String processCustomerProfile (@ModelAttribute @Valid CustomerDetails customerDetails, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Customer profile");
            model.addAttribute("serviceAddress", customerDetails.getServiceAddress());
            model.addAttribute("phone", customerDetails.getPhone());
            return "redirect:";
        }

        customerDetailsRepository.save(customerDetails);
        return "redirect:";
    }
}

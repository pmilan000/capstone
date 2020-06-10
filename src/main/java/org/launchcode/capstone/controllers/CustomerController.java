package org.launchcode.capstone.controllers;

import org.launchcode.capstone.models.Customer;
import org.launchcode.capstone.models.data.CustomerRepository;
import org.launchcode.capstone.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/customer")
    public String displayCustomer(@RequestParam(required = false) Integer customerId, Model model) {

        if (customerId == null) {
            model.addAttribute("title", "Customer");
            model.addAttribute("customer", customerRepository.findAll());
        } else {
            Optional<Customer> result = customerRepository.findById(customerId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Customer ID: " + customerId);
            } else {
                Customer customer = result.get();
                model.addAttribute("title", "Profiles: " + customer.getFirstName());
                model.addAttribute("customer", customer.getLastName());
            }
        }
        return "customer";
    }
}

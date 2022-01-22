package pl.alex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.alex.dao.CustomerService;
import pl.alex.entity.Customer;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping("")
    public String getCustomers(Model model) {
        model.addAttribute("customers", service.getCustomers());
        return "customer-list";
    }

    @GetMapping("/add")
    public String addCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "add-customer";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer")Customer customer,Model model) {
        service.saveCustomer(customer);
        return "redirect:/customer";
    }
}

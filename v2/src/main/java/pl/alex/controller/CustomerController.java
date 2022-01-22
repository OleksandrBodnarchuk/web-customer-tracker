package pl.alex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        service.saveCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") long id) {
        Customer customer = service.findCustomerById(id);
        service.deleteCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") long id, Model model) {
        Customer customer = service.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "add-customer";
    }

    @GetMapping("/ok")
    public String ok() {
        return "deleteModal";
    }
}

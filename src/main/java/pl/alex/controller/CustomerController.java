package pl.alex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.alex.entity.Customer;
import pl.alex.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllStudents();
        model.addAttribute("customers", customers);
        return "list-customers";
    }

    @GetMapping("/new")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    @PostMapping("")
    public String saveStudent(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customer";
    }
}

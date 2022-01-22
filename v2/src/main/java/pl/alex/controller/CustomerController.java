package pl.alex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.alex.dao.CustomerService;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService dao;

    @GetMapping("")
    public String getCustomers(Model model) {
        model.addAttribute("customers", dao.getCustomers());
        return "customer-list";
    }
}

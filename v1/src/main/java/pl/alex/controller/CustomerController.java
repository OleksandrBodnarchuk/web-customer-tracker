package pl.alex.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String saveStudent(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/update/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
        Customer customer = customerService.getById(id);
        model.addAttribute("customer", customer);
        return "edit-customer";
    }

    @PostMapping("/{id}")
    public String updateCustomer(@PathVariable Long id,
                                 @ModelAttribute("customer") Customer customer,
                                 Model model) {
        Customer fromDB = customerService.getById(id);
        fromDB.setFirstName(customer.getFirstName());
        fromDB.setLastName(customer.getLastName());
        fromDB.setEmail(customer.getEmail());
        customerService.update(fromDB);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){
        customerService.deleteById(id);
        return "redirect:/customer";
    }
}

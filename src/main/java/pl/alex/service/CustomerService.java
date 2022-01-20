package pl.alex.service;

import pl.alex.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllStudents();

    void save(Customer customer);
}

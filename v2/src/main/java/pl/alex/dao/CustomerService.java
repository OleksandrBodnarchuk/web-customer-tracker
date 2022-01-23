package pl.alex.dao;

import org.springframework.stereotype.Service;
import pl.alex.entity.Customer;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer findCustomerById(long id);

    void deleteCustomer(Customer customer);

    List<Customer> getCustomersByName(String name);
}

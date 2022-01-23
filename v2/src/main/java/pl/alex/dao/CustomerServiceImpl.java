package pl.alex.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.alex.entity.Customer;
import pl.alex.repository.CustomerRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        repository.save(customer);
    }

    @Override
    public Customer findCustomerById(long id) {
        return repository.findById(id).get(); // throws exception
    }

    @Override
    public void deleteCustomer(Customer customer) {
        repository.delete(customer);
    }

    @Override
    public List<Customer> getCustomersByName(String name) {
        return repository.getBySearchedName(name);
    }
}

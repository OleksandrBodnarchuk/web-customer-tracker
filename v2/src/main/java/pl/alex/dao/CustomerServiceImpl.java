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
}

package pl.alex.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.alex.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

package pl.alex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.alex.entity.Customer;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT c from Customer c where c.firstName=?1 or c.lastName=?1")
    List<Customer> getBySearchedName(String name);
}

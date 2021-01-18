package co.org.juancsr.ereservation.repository;

import co.org.juancsr.ereservation.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaces para definir las operaciones de bd relacionadas con el cliente
 * @author juancsr
 */
public interface CustomerRepository extends JpaRepository<Customer, String> {

    /**
     * Method for looking up customers by their lastname
     * @param lastname
     * @return
     */
    public List<Customer> findByLastname(String lastname);

    /**
     * Method for search one customers by its email
     * @param email
     * @return
     */
    public Customer findByEmail(String email);
}

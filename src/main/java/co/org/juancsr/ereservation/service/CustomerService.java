package co.org.juancsr.ereservation.service;

import co.org.juancsr.ereservation.model.Customer;
import co.org.juancsr.ereservation.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * Class to define the customer's services
 * @author juancsr
 */
@Service
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customRepository) {
        this.customerRepository = customRepository;
    }

    /**
     * Save method
     * @param customer
     * @return
     */
    @Transactional
    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    /**
     * Update method
     * @param customer
     * @return
     */
    @Transactional
    public Customer update(Customer customer) {
        return this.customerRepository.save(customer);
    }

    /**
     * Delete method
     * @param customer
     */
    @Transactional
    public void delete(Customer customer) {
        this.customerRepository.delete(customer);
    }

    /**
     * findById customer
     * @param email
     * @return
     */
    public Customer findByEmail(String email) {
        return this.customerRepository.findByEmail(email);
    }

    public Customer findById(String id) { return this.customerRepository.findById(id).get(); }

    public List<Customer> findAll() { return this.customerRepository.findAll(); }
}

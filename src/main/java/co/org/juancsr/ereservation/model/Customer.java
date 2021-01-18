package co.org.juancsr.ereservation.model;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Represents the customer table
 * @author juancsr
 */
@Data
@Entity
@Table(name="customer")
@NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.id = ?1")
public class Customer {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String lastname;
    private String identify;
    private String address;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "customer")
    private Set<Reservation> reservations;
}

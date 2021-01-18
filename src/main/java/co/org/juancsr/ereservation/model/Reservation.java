package co.org.juancsr.ereservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
//import java.sql.Date;
import java.util.Date;

/**
 * Class that represents the reservation table
 * @author juancsr
 */
@Data
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;
    @Temporal(TemporalType.DATE)
    private Date reservationDate;
    @Temporal(TemporalType.DATE)
    private Date reservationExitDate;
    private int amountPeople;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
}

package co.org.juancsr.ereservation.resources.vo;
import co.org.juancsr.ereservation.model.Reservation;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Represents the customer virtual object
 * @author juancsr
 */
@Data
public class CustomerVO implements Serializable {
    private String id;
    private String name;
    private String lastname;
    private String identify;
    private String address;
    private String phone;
    private String email;
}

package co.org.juancsr.ereservation.repository;

import co.org.juancsr.ereservation.model.Customer;
import co.org.juancsr.ereservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import java.sql.Date;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

    @Query("SELECT r FROM Reservation r WHERE r.reservationDate = :startDate AND r.reservationExitDate = :endDate")
    public List<Reservation> find(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
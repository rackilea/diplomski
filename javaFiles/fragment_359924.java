package de.professional_webworkx.reservationmanager.business;

import de.professional_webworkx.reservationmanager.model.Reservation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * ReservationService
 * persist, query, delete, edit Reservations
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 * @version 1.0
 */
public class ReservationService {

    public ReservationService() {
        super();
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        // fetch all reservations from database
        reservations.add(new Reservation("Patrick", LocalDate.now(), LocalDate.now().plusWeeks(3)));
        reservations.add(new Reservation("userXYZ", LocalDate.now(), LocalDate.now().plusWeeks(2)));
        return reservations;
    }
}
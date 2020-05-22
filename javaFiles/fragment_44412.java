import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {

    List<Reservation> reservations = new ArrayList<>();

    //Adds a Reservation object to the list
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }
    // Prints a Reservation from the list based on seat number and seat letter
    public void viewReservation(int seatNumber, char seatLetter){
        for(Reservation res : reservations){
            // if seat number and seat letter dont match continue to the next reservation
            if(res.getSeatNumber() != seatNumber && res.getSeatLetter() != seatLetter){ continue; }
                System.out.println(res.toString());
            return;
        }
}
    // Prints all the Reservation objects of the list
    public void viewAllReservations(){
        for(Reservation res : reservations){
            System.out.println(res.toString() + "\n");
        }
    }
}
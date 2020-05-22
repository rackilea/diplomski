public int createBooking(String hallName, int showId){
    synchronized ((hallName + showId).intern()) {
        //check if there are any available seats
        //access DAO layer to create booking
        return bookingId;
    }
}
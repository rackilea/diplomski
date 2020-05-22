for (int i = 0; i < index; ++i) {
   seatBookingSystem current = seats[i];
   // TODO: expand expression to test for the other properties
   if (current.getSeatClass().equals(classWanted)) {
     System.out.println("Matching seat: " + current.getSeatNumber() + ", " +
         "Price: " + current.getSeatPrice());
   }
}
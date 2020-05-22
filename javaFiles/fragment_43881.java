List<Taxi> taxis;

boolean chooseTaxi(RideNumber rideNumber) {
    for (Taxi taxi : taxis) {
        boolean isAccepted = taxi.notify(this, rideNumber);
        if (isAccepted) {
           markTaxiRideAsAccepted(taxi, rideNumber);
           return true;
        }
    }
    return false; // No taxi accepted the ride.
}
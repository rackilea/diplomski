List<Taxi> taxis;

void notifyAllTaxis(RideNumber rideNumber) {
    for (Taxi taxi : taxis) {
        taxi.notify(this, rideNumber);            
        }
    }        
}

ClientInfo getClientInfo(this, rideNumber) {
    if (isRideNotYetAccepted(rideNumber)) {
        markRideAsAccepted(taxi, rideNumber);
        return getClientInfo(rideNumber);
    }
    else return null;
}
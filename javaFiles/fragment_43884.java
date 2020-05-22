void notify(Operator operator, RideNumber rideNumber) {
    if (!isTaxiAlreadyCarryingPassenger()) {

        ClientInfo clientInfo = operator.getClientInfo(this, rideNumber);
        if (clientInfo != null) startClientProcess(clientInfo);
    }
}
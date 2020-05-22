boolean notify(Operator operator, RideNumber rideNumber) {
    if (isTaxiAlreadyCarryingPassenger()) return false;

    ClientInfo clientInfo = operator.getClientInfo(this, rideNumber);
    startClientProcess(clientInfo);

    return true;
}
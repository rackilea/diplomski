interface TrainArrivedHandler {
    void apply(String track, String lineNumber);
    static TrainArrivedHandler forAll(Iterable<TrainArrivedHandler> all) {
        return (track, lineNumber) -> all.forEach(h -> h.apply(track, lineNumber));
    }
}
interface PassengerArrivedHandler {
    void apply(String track);
    static PassengerArrivedHandler forAll(Iterable<PassengerArrivedHandler> next) {
        return track -> next.forEach(h -> h.apply(track));
    }
}

final class TrainStationImpl implements TrainStation {

    private final Set<TrainArrivedHandler> trainArrivedHandler=new HashSet<>();
    private final Set<PassengerArrivedHandler> passengerArrivedHandler=new HashSet<>();

    public void onTranArrived(TrainArrivedHandler handler) {
        trainArrivedHandler.add(handler);
    }
    public void onPassengerArrived(PassengerArrivedHandler handler) {
        passengerArrivedHandler.add(handler);
    }

    /** Generates some events. */
    public void makeSomethingHappen() {
        TrainArrivedHandler.forAll(trainArrivedHandler).apply("34", "S12");
        // Wants to catch the S12, but is obviously too late now.
        PassengerArrivedHandler.forAll(passengerArrivedHandler).apply("2");
    }
}
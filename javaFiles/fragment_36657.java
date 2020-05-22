public interface Car {
    String manufacturer();
}

public interface PassengerCar {
    Integer numberOfSeats();
}

public interface TimeMachine {
    void travelTo(Date destination);
}

public class DMC12 implements PassengerCar {
    @Override
    public String manufacturer() { return "DeLorean Motor Company"; }

    @Override
    public Integer numberOfSeats() { return 2; }
}

pubblic class DeLoreanTimeMachine extends DMC12 implements TimeMachine {
    private FluxCapacitor fluxCapacitor = new FluxCapacitor();

    @Override
    public void travelTo(Date destination) { fluxCapacitor.travelTo(destination); }
}
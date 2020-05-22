public class Flight {
    private int flying = 0;

    protected boolean fly() {
        flying = 1;
        return isFlying();
    }

    private boolean isFlying() {
        return flying > 0;
    }
}

public class CargoFlight extends Flight {
    @Override
    protected boolean fly() {
        throw new IllegalAccessError();
    }

    public boolean startFlight(int passengers) {
        if (passengers <= 0) {
            throw new IllegalArgumentException();
        }

        return super.fly();
    }
}
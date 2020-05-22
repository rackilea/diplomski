public class CargoFlight extends Flight {
    private int passengers = 0;

    public void setPassengers(int p) {
        passengers = p;
    }

    @Override
    public boolean fly() {
        if (passengers <= 0) {
            throw new IllegalStateException(); // or whichever
        }

        return super.fly();
    }
}
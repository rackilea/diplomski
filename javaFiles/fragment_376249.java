Public Class Car {
    private int speed;
    private float fuelNeeded;
    private float afRatio = 14.7;

    public void speedUp { speed++; }

    public void speedDown { speed--; }

    public float getFuelNeeded {
        calculateFuelNeeded(speed);
        return fuelNeeded;
    }

    private void calculateFuelNeeded (int speed) {
        // Do some complex calculation
        fuelNeeded = someValue / afRatio;
    }
}
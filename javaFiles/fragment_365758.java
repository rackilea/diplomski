public final class SensorReader {
    private final Iterable<Sensor> sensors;
    public SensorReader(Iterable<Sensor> sensors) {
        this.sensors = sensors;
    }
    public void readSensors() {
        for (Sensor sensor : sensors) {
            Reading reading = sensor.getReading();
            // so stuff with reading
        }
    }
}
import java.util.Arrays;

public final class Application {
    public static void main(String[] args) {
        Sensor sensor = new MotorEncoder();
        SensorReader sensorReader = new SensorReader(Arrays.asList(sensor));
        sensorReader.readSensors();
    }
}
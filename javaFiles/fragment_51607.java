public class RealTimeThreadFactory {

    private final SensorReadingService sensorReadingService;

    public RealTimeThreadFactory(SensorReadingService sensorReadingService) {
        this.sensorReadingService = sensorReadingService;
    }

    public RealTimeThread getObject(BufferedReader input, Map<String, String> rt, double[] offset, double[] sens) {
          return new RealTimeThread(input, rt, offset, sens, sensorReadingService);
    }
}
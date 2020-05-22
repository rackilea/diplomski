public class TrafficMonitor {
    private static ConcurrentMap<String, TrafficMonitor> instances = new ConcurrentHashMap<>();
    private String busNumber;
    private boolean initialized;

    private TrafficMonitor(String busNumber) {
        this.busNumber = busNumber;
    }

    private synchronized void initialize() throws IOException {
        if (!initialized) {
            doIoOperation();
            initialized = true;
        }
    }

    public static TrafficMonitor forBus(String busNumber) throws IOException {
        TrafficMonitor result = instances.computeIfAbsent(busNumber, TrafficMonitor::new);
        result.initialize();
        return result;
   }
}
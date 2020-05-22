public static TrafficMonitor forBus(String busNumber) {
    return instances.computeIfAbsent(busNumber, busNumber -> {
        try {
            return new TrafficMonitor(busNumber);
        } catch(IOException e) {
            throw UnchedkIOException(e);
        }
    });
}
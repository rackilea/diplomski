private TrafficMonitor(String busNumber) {
    this.busNumber = busNumber;
    try { 
        doIoOperation();
    } catch(IOException e) {
        throw UnchedkIOException(e);
    }
}
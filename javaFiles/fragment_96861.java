public void add(String planeId, int capacity) {
    airport.add(new Airport(planeId, capacity));
}

public void addFlight(String planeId, String dest, String dep) {
    airport.add(new Airport(planeId, dest, dep));
}
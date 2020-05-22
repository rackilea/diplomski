private Airport sortByDistance(Location location) {
    List<Airport> airports;
    if (!airports.isEmpty()) {
        ArrayList<AirportWithDistance> distanceArrayList = new ArrayList<AirportWithDistance>(airports.size());
        for (Airport airport : airports) {
            distanceArrayList.add(new AirportWithDistance(airport, getDistance(airport, location)));
        }
        // replace start
        Collections.sort(distanceArrayList, new DistanceToAirportComparator());
        return airports.get(0).airport;
        // replace end
        //also seems u should replace the above to the line below instead, as you only wan min
        //return Collections.min(distanceArrayList, new DistanceToAirportComparator()).airport;
    }
    return null;
}


private static double getDistance(Airport airport, Location location){
    Location airportLocation = new Location(LocationManager.GPS_PROVIDER);
    airportLocation.setLatitude(airport.getLocation().getLatitude());
    airportLocation.setLongitude(airport.getLocation().getLongitude());
    return location.distanceTo(airportLocation);
}

public static class AirportWithDistance {
    Airport airport;
    double distance;

    AirportWithDistance(Airport airport, double distance) {
        this.airport = airport;
        this.distance = distance;
    }

}

public static class DistanceToAirportComparator implements Comparator<AirportWithDistance> {

    public DistanceToAirportComparator() {
    }

    @Override
    public int compare(AirportWithDistance airport1, AirportWithDistance airport2) {
        return Double.compare(airport1.distance, airport2.distance);
    }

}
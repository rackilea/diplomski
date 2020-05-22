Flight[] flights = { Flight1, Flight2 };
for (Flight f : flights) {
    String potentialFlight = (f.getLocations(response));
    if (potentialFlight != null) {
        System.out.println(potentialFlight);
    }
}
public static Map<String, Integer> calculatePrice(List<Flight> flightList) {
    Map<String, Integer> priceMap = new HashMap<>();
    int price = 0;
    int pricePerPassenger = 0;
    for (Flight flight : flightList) {
        price = price + flight.getPrice();
        pricePerPassenger = (pricePerPassenger) + (flight.getPrice() / flight.getPassgers());
    }
    priceMap.put("price", price);
    priceMap.put("pricePerPassenger", pricePerPassenger);
    return priceMap;
}
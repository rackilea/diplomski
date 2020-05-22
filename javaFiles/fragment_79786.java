fun List<Trip>.frequentPassengers(minTrips: Int): Set<Passenger> =
    this
       .flatMap { it.passengers }
       .groupingBy { it }
       .eachCount()
       .filterValues { it >= minTrips }
       .keys
for (List<Trip> trips : feed1.values()) {
    for (Trip trip : trips) {
        Set<Trip> potentialMatchingTrips = new HashSet<>();

        for (StopTime stopTime : trip.getStopTimes()) {
            List<Trip> list = tripsByStopTime.get(stopTime);

            if (list != null) {
                potentialMatchingTrips.add(list);
            }
        }

        for (Trip potentialMatchingTrip : potentialMatchingTrips) {
              // Check here if it was a subset.
        }
    }
}
for (List<Trip> trips : feed2.values()) {
    for (Trip trip : trips) {
        for (StopTime stopTime : trip.getStopTimes()) {
            tripsByStopTime.computeIfAbsent(stopTime, k -> new ArrayList<>())
                 .add(trip);
        }
    }
}
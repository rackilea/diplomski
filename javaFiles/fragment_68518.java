private Map<Beacon,Double> myBeaconDistances = new HashMap<>();

private Map<Beacon,Double> getBeaconDistances(List<Beacon> beacons){
    for (Beacon beacon : beacons) {
        double distance = Utils.computeAccuracy(beacon);
        this.myBeaconDistances.put(beacon, distance);

    }

    return myBeaconDistances;
}
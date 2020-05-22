public List<BeaconParser> getBeaconParsers() {
    if (isAnyConsumerBound()) {
        return Collections.unmodifiableList(beaconParsers);
    }
    return beaconParsers;
}
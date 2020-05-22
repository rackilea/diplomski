public static class LocationEventFilteringManagerMap extends
        TreeMap<Antenna, LocationEventFilteringManager> {

    public LocationEventFilteringManagerMap() {
        super(new Antenna.NameComparator());
    }

}
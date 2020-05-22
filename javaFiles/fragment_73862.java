public class Route {
    private List<Station> stations;

    public Station firstStation() {
        return stations.get(0);
    }

    public Station lastStation() {
        return stations.get(stations.size() - 1);
    }

    public Iterable<Station> getStations() {
        return stations;
    }

    private static class Station {

    }
}
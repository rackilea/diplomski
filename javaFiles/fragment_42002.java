static final Location origin;

public class LocationComparator implements Comparator {
  @Override
  public int compare(Location o1, Location o2) {
    return Doubles.compare(distance(o1.lat, origin.lat, o1.lon, origin.lon, 0, 0),
                           distance(o2.lat, origin.lat, o2.lon, origin.lon, 0, 0));
  }
}
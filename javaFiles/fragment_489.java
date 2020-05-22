public static class SnappedPoints {
  private List<Point> snappedPoints;

  public String toString() {
    return snappedPoints.toString();
  }
}

public static class Point {
  private Location location;

  public double getLatitude() {
    return location.getLatitude();
  }

  public double getLongitude() {
    return location.getLongitude();
  }

  public String toString() {
    return "{" + location.getLatitude() + "," + location.getLongitude() + "}";
  }
}

public static class Location {
  double latitude;
  double longitude;

  public double getLatitude() {
    return latitude;
  }
  public double getLongitude() {
    return longitude;
  }
}
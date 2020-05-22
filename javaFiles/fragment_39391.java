public class ConnectionAgent implements CommUser {
  final Point position;

  public ConnectionAgent(Connection<LengthData> c) {
    position = Point.centroid(asList(c.from(), c.to()));
  }

  @Override
  public Optional<Point> getPosition() {
    return Optional.of(position);
  }

  @Override
  public void setCommDevice(CommDeviceBuilder builder) {}
}
// ctor example
public JpaPoint(Point point) {
  this.x = point.getCoordinates().x;
  this.y = point.getCoordinates().y;
  this.z = point.getCoordinates().z;
}

// helper method
@Transient
public Point getPoint() {
  return new Point( new Coordinates( x, y, z ) );
}
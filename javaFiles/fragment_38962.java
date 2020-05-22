public double distanceFrom(Point other){
  //System.out.println("x coordinate of this: " + xCoordinate());
  //System.out.println("x coordinate of other: " + other.xCoordinate());
  double xDistance = x - other.xCoordinate();
  double yDistance = y - other.yCoordinate();
  double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
  return distance;
}
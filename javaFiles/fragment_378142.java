/**
* Returns true if the point x,y is already occupied by a zombie
*/
boolean isOccupied(double x, double y) {
  for (Zombie z : zombies) {
    if (z.getBounds().contains(new Point(x,y))) {
      return true;
    }
  }
  return false;
}
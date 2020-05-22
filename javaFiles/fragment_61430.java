Rectangle r = ...;
Area a = new Area(r);
a.transform(AffineTransform.rotate(Math.PI/2));
if (a.contains(event.getX(), event.getY()) {
  ...
}
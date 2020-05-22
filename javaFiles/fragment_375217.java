class Circle {
  Shape shape;
  Color color;

  ... //additional properties, e.g. position, and methods

  public boolean wasHit(int x, int y) {
    return shape.contains(x,y);
  }

  public boolean isValid() {
    return Color.WHITE.equals( color );
  }
}
static class Points {
  static final Interner<Point> INTERNER = Interners.newStrongInterner();

  public static Point cached(final int x, final int y) {
    return INTERNER.intern(new Point(x, y));
  }
}
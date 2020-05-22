public static Point getLocationOnCurrentScreen(final Component c) {
  final Point relativeLocation = c.getLocationOnScreen();

  final Rectangle currentScreenBounds = c.getGraphicsConfiguration().getBounds();

  relativeLocation.x -= currentScreenBounds.x;
  relativeLocation.y -= currentScreenBounds.y;

  return relativeLocation;
}
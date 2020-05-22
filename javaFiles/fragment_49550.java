Rectangle2D bounds = getWindowScreen().getVisualBounds();
double centerX = bounds.getMinX() + (bounds.getWidth() - getWidth())
                                           * CENTER_ON_SCREEN_X_FRACTION;
double centerY = bounds.getMinY() + (bounds.getHeight() - getHeight())
                                           * CENTER_ON_SCREEN_Y_FRACTION;
x.set(centerX);
y.set(centerY);
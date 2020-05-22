protected void internalUpdateBounds(final double x, final double y, final double width, final double height) {
    final Rectangle2D pathBounds = path.getBounds2D();
    ...
    final double scaleX;
    if (adjustedWidth == 0 || pathBounds.getWidth() == 0) {
            scaleX = 1;
    }
    ...
    final double scaleY;
    if (adjustedHeight == 0 || pathBounds.getHeight() == 0) {
         scaleY = 1;
    }
    ...
    TEMP_TRANSFORM.scale(scaleX, scaleY);
    ...
    path.transform(TEMP_TRANSFORM);
}
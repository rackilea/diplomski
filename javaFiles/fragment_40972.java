...
boolean result = GLU.gluProject((float) (x), (float) y, (float) (z), modelView, projection, viewport, screenCoords);
if (result && screenCoords.get(2) < 0) {
    return new int[] { (int) screenCoords.get(0), (int) screenCoords.get(1)};
}
return null;
// 1 deltaX = 0.01 alpha
// This is just an example coefficient.
// Replace it with a value that fits your needs
private static final float COEFFICIENT = 0.01;

private float calculateDeltaAlpha(float deltaX) {
  return deltaX * COEFICIENT;
}

private void incrementViewAlpha(View view, float distanceX) {
  float oldAlpha = gestureLayout.getAlpha();
  if (oldAlpha > 0.29 && oldAlpha < 0.80) {
    gestureLayout.setAlpha(oldAlpha + calculateAlphaDelta(distanceX));
  }
}

private void decrementViewAlpha(View view, float distanceX) {
  float oldAlpha = gestureLayout.getAlpha();
  if (oldAlpha > 0.29 && oldAlpha < 0.80) {
    gestureLayout.setAlpha(oldAlpha - calculateAlphaDelta(distanceX));
  }
}
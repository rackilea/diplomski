private void calculateAngle(Point target) {
  // calculate the angle from the center of the image
  float deltaY = target.y - (imageLocation.y + bi.getHeight() / 2);
  float deltaX = target.x - (imageLocation.x + bi.getWidth() / 2);
  angle = (float) Math.atan2(deltaY, deltaX);
  if (angle < 0) {
     angle += (Math.PI * 2);
  }
}
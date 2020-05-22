public void setRandomDirection() {
  double direction = Math.random()*2.0*Math.PI;
  double speed = 10.0;
  xVelocity = (int) (speed*Math.cos(direction));
  yVelocity = (int) (speed*Math.sin(direction));
}
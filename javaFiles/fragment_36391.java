public void cycle() {
  //move forward
  x += xVelocity;
  y += yVelocity;

  if (Math.random() < 0.1) {//sometimes..
    setRandomDirection();   //..change course to a random direction
  }
}
public void cycle() {
  x += xVelocity;
  y += yVelocity; //added
  if (x >= RIGHT_WALL) {
    x = RIGHT_WALL;
    setRandomDirection();//bounce off in a random direction
  }
  if (x <= LEFT_WALL) {
    x = LEFT_WALL;
    setRandomDirection();
  }
  if (y >= DOWN_WALL) {
    y = DOWN_WALL;
    setRandomDirection();
  }
  if (y <= UP_WALL) {
    y = UP_WALL;
    setRandomDirection();
  }
}
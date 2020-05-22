// variables for your objects - where are they and how big?
float ballX, ballY;
float ballRadius;
float hammerX, hammerY;
float hammerRadius;

void setup() {

  // check for a collision
  boolean hit = ballBallCollision(ballX, ballY, ballRadius, hammerX, hammerY, hammerRadius);
  if (hit) {
    // hit!
  }
  else {
    // not :(
  }
}

// a function to check for ball-ball collision
boolean ballBallCollision(float ballX, float ballY, float ballRadius, float hammerX, float hammerY, float hammerRadius) {
  // calculate distance between the objects using the Pythagorean Theorem
  float xDist = hammerX - ballX;
  float xDist = hammerY - ballY;
  float dist = sqrt( (xDist*xDist) + (yDist*yDist) );

  if (dist < ballRadius + hammerRadius) {
    return true;
  }
  return false;
}
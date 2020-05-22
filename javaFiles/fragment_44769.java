float BallY = 50; // y value of the ball
float BallX = 260; // x value of the ball
int counter;

void setup()
{
  size(512, 348); //width and height of screen
  counter = 0;
}

void draw()
{
  background(255);
  fill(0);
  ellipse(BallX, BallY, 15, 15); //ball that will fall 
  BallY++; //ball's y value increases each frame
  if (BallY > height) //if ball's y value is greater than the screen
  {
    BallY = 0; //reset the y value of the ball back to 0
    counter++;
  }

  for (int i = 0; i < counter; i++) {
    rect(i * 20, 0, 20, 20);
  }
}
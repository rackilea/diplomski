float r = 0; //radius
float x = 100; // x of the object
float y = 100; // y of the object
float theta = 0; //angle

void setup() {
  size(800,600);
  background(0);
  smooth();
  ellipseMode(CENTER); // draw ellipses based on their center

  // translate the x and y from top-left origin to center origin 
  x -= width/2;
  y -= height/2;

  r = sqrt(x*x+y*y); //polar coordinate - distance from x,y to 0,0 on the grid
  theta = atan(y/x); // angle to 0,0 on the grid

}

void draw() {
  translate(width/2, height/2); // translate the whole canvas

  fill(0,255,0);
  ellipse(0,0,20,20); // mark the center of the canvas

  fill(0,0,255);
  ellipse(x,y,20,20); // mark the start point for the circle

  // flip the angle if left of the origin
  int flip = 1;
  if(x < 0) flip = -1;

  float x = r * cos(theta) * flip;
  float y = r * sin(theta) * flip;

  // Draw an ellipse at x,y
  noStroke();
  fill(255,0,0);

  ellipse(x, y, 16, 16); 

  if (r>0){
  r -= 1; // Decrement the radius
  theta += 0.01; // Increment the angle
  }

}
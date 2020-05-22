float x = 100; // x of the object
float y = 100; // y of the object
float r = 0; // radius
float theta = 0; // angle

void setup() {
  size(800,600);
  background(0);
  smooth();
  ellipseMode(CENTER); // draw ellipses based on their center

  // distance between point and center of screen
  r = dist(x,y,width/2,height/2);

  // http://stackoverflow.com/a/7586218/1736092
  // angle of line between point and center of screen 
  // relative to x-axis
  float dX = x - width/2;
  float dY = y - height/2; 
  theta = atan2(dY, dX);

  stroke(0, 255, 0); // green stroke
  line(x, y, width/2, height/2); // draw radius

  noStroke();
  fill(0, 255, 0);  // green fill
  ellipse(width/2, height/2, 20, 20); // mark the center of the canvas
  fill(0, 0, 255); // blue fill
  ellipse(x, y, 20, 20); // mark the start point for the circle
}

void draw() {
  float x = r * cos(theta) + width/2;
  float y = r * sin(theta) + height/2;

  noStroke();
  fill(255,0,0); // red fill
  ellipse(x, y, 16, 16); 

  if(r>0) {
    r -= 1; // Decrement the radius
    theta += 0.01; // Increment the angle
  }
}
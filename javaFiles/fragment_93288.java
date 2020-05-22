float scale = 1;
// displacement left/right
float xPan = 720;
// displacement up/down
float yPan = 450;
boolean zoomIn = true;

void setup() {
  size(1440, 900);
}


void draw() {

  // allows us to zoom into the center of the screen rather than the corner
  translate(width/2, height/2);
  scale(scale);
  translate(-xPan, -yPan);
  background(200);

  // draws the ellipse in the center
  ellipse(width/2, height/2, 100, 100);

  // does the zooming
  if (zoomIn) {
    scale *= 1.01;
  }
}
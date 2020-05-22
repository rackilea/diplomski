Circle circle;

void setup() {
  size(500, 500);
  ellipseMode(RADIUS);
  circle = new Circle(100, 200, 50);
}

void draw() {
  background(0); 

  circle.draw();
}

class Circle {
  float x;
  float y;
  float r;

  public Circle(float x, float y, float r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }

  void draw() {

    if(dist(mouseX, mouseY, x, y) < r){
      //mouse is inside circle

      if(mousePressed){
        //mouse is being dragged
        fill(255, 0, 0);

        //move the circle to the mouse position
        x = mouseX;
        y = mouseY;
      }
      else{
        //mouse is not clicked
        fill(0, 255, 0);
      }


    }
    else{
      //mouse is outside circle
      fill(0, 0, 255);
    }

    ellipse(x, y, r, r);
  }
}
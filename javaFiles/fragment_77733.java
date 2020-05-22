Circle circle;

void setup() {
  size(500, 500);
  ellipseMode(CENTER);
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
    ellipse(x, y, r, r);
  }
}
class Point {
  float xPos;
  float yPos;
  PApplet sketch;

  Point(float x, float y, PApplet sketch) {
    xPos = x;
    yPos = y;
    this.sketch = sketch;
  }

  void drawMe(){
    sketch.point(xPos, yPos);
  }
}
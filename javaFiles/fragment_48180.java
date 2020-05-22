void setup() {
  size(100, 100);

  String[] args = {"TwoFrameTest"};
  SecondApplet sa = new SecondApplet();
  PApplet.runSketch(args, sa);
}

void draw() {
  background(0);
  ellipse(50, 50, 10, 10);
}     

public class SecondApplet extends PApplet {

  public void settings() {
    size(200, 100);
  }
  public void draw() {
    background(255);
    fill(0);
    ellipse(100, 50, 10, 10);
  }
}
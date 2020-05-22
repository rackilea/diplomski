public class TestSketch extends PApplet {
  public void setup() {
    background(32);
    ellipse(50, 50, 25, 25);
    noLoop();
  }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "TestSketch" };
    PApplet.main(appletArgs);
  }
}
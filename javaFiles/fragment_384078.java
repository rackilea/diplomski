public class MyPapplet extends PApplet {

  public static void main(String... args){
    String[] pArgs = {"MyPapplet "};
    MyPapplet mp = new MyPapplet ();
    PApplet.runSketch(pArgs, mp);
  }

  public void settings() {
    size(200, 100);
  }
  public void draw() {
    background(255);
    fill(0);
    ellipse(100, 50, 10, 10);
  }
}
public class MySketch extends PApplet{
  PImage img;

  void setup(){
    img = new MyInnerClass().getImage("img.jpg");
  }

  static class MyInnerClass{
    public PImage getImage(String loc){
      return loadImage(loc);
    }

  }
}
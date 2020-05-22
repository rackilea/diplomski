public class MySketch extends PApplet{
  PImage img;

  void setup(){
    img = MyInnerClass.getImage("img.jpg");
  }

  class MyInnerClass{
    public static PImage getImage(String loc){
      return loadImage(loc);
    }

  }
}
public class MySketch extends PApplet{

  MyOtherClass myOtherClass;

  void setup(){
    myOtherClass = new MyOtherClass(this);
  }

  void draw(){
    myOtherClass.drawCircle();
  }
}

public class MyOtherClass{
  PApplet sketch;

  public MyOtherClass(PApplet sketch){
    this.sketch = sketch;
  }

  void drawCircle(){
    sketch.ellipse(100, 100, 100, 100);
  }
}
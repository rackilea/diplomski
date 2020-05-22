public abstract class Shape {
  public abstract void printCoordinates();
}

public class Line extends Shape {
   @Override
   public void printCoordinates() {
      System.out.println(.... print your coordinates here);
   }
}
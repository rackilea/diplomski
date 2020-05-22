public interface CircleInfo {
  Color getBorderColor();
  /* some other methods */
}

public class CircleShape implements Shape, CircleInfo {
  public Color getBorderColor() {
    return Colors.Black; // not sure if it works, just an example
  }

  public void draw() {
    drawingAPI.drawCircle(x, y, radius, this);
  }   

  /* Other methods implementation here */
}

// DrawingAPI modification
interface DrawingAPI {
  public void drawCircle(double x, double y, double radius, CircleInfo info);
}

// Concrete implementation
class DrawingAPI1 implements DrawingAPI {
  public void drawCircle(double x, double y, double radius, CircleInfo info) {
    System.out.printf("API1.circle at %f:%f radius %f color %s\n",
      x, y, radius, info.getBorderColor().toString());
}
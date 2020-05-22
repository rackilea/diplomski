//Super Class
public class Circle {

  protected double radius;
  protected double area;

  public Circle(double radius) {
    this.radius = radius;
    this.area = getArea();
  }

  protected double getArea() {
    area = Math.pow(radius, 2) * Math.PI;
    return area;
  }
}

//Sub Class
public class Cone extends Circle {

private double height;

public Cone(double radius, double height) {
    super(radius);
    this.height = height;
}

public double getVolume() {
    {
      return (area * height / 3);
    }
  }
}
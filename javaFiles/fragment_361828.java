import java.util.*;

public class TestExample
{
    public static void main(String[] args)
    {
        GeometricObject2 rectangle1 = new MyRectangle2D(2, 2, 3, 4, "Red", true);
        System.out.println(rectangle1.getArea());
    }
}


abstract class GeometricObject2 {
    private String color = "white";
    private boolean filled;


    protected GeometricObject2() {
    }


    protected GeometricObject2(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}



class MyRectangle2D extends GeometricObject2
{
    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle2D(double x, double y, double width, double height,
                         String color, boolean filled) {
        super(color, filled);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}
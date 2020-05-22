public class Circle

    private int radius = getRadius();
    private double area = getArea();

    public Circle(int r) 
    {
        r = radius;
    }

    public int getRadius()
    {
        return radius;
    }

    public double getArea(int r)
    {
        return area = Math.PI * r * r;  
    }

}
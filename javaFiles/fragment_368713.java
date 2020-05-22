public class Circle
{
    double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public static Circle fromCircumference(double circumference)
    {
        return new Circle(circumference / (Math.PI * 2));
    }

    public static Circle fromArea(double area)
    {
        return new Circle(Math.sqrt(area / Math.PI));
    }

    public double getCircumference()
    {
        return 2 * Math.PI * radius;
    }

    public double getRadius()
    {
        return radius;
    }

    public double getDiameter()
    {
        return 2 * radius;
    }

    public double getArea()
    {
        return Math.PI * radius * radius;
    }
}
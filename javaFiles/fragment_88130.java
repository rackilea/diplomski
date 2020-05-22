public class Circle  {

   private double radius;

   public Circle(double r) {
    radius = r;

   }

   public double getRadius()  {
      return radius;
   }

   public void setRadius(double r)  {
   }

   public double diameter()  {
      double diameter = radius * radius;
      return diameter;
   }

   public double area()   {
      double area = Math.PI * (radius * radius);
      return area;
   }

   public double circumference()   {
      double circumference = 2 * Math.PI * radius;
      return circumference;
   }
}
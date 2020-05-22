/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangles;

/**
 *
 * @author jstil
 */
public class Triangle {

    private double x1;
   private double y1;
   private double x2;
   private double y2;
   private double x3;
   private double y3;
   public double lengthA;
   public double lengthB;
   public double lengthC;
   public double angleA;
   public double angleB;
   public double angleC;
   private double perimeter;
   public double height;
   private double area;

   public double calcArea()
   {
      area = .5 * lengthC * height;
      return area;
   }

   public double calcPerimeter()
   {
      perimeter = lengthA + lengthB + lengthC;
      return perimeter;
   }

   public void setLengthA( double x2 , double x3)
   {
      lengthA = Math.sqrt(Math.pow((x2 - x3),2) + Math.pow(height,2));

   }

   public void setLengthB(double x3, double x1)
   {
      lengthB = Math.sqrt(Math.pow((x3 - x1),2) + Math.pow(height,2));

   }

   public void setLengthC(double x2, double x1)
   {
      lengthC = x2 - x1;

   }

   public void setHeight(double y3, double y1)
   {
      height = y3 - y1;

   }

   public void setAngleA()
   {
      angleA = Math.abs(Math.toDegrees(Math.asin(height/ lengthB)));

   }

   public void setAngleB()
   {
      angleB = Math.abs(Math.toDegrees(Math.asin(height / lengthA)));

   }

   public void setAngleC()
   {
      angleC = 180 - angleA - angleB;

   }
}
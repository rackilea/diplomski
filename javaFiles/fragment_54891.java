package triangles;

import javax.swing.*;
public class Triangles {

/**
 * @param args the command line arguments
 */
public static void main(String[] args)
{
   double x1;
  double y1;
  double x2;
  double y2;
  double x3;
  double y3;
  String v1;
  String v2;
  String v3;
  String v4;
  String v5;
  String v6;

  v1 = JOptionPane.showInputDialog("Enter x1 for point A");
  v2 = JOptionPane.showInputDialog("Enter y1 for point A");
  v3 = JOptionPane.showInputDialog("Enter x2 for point B");
  v4 = JOptionPane.showInputDialog("Enter y2 for point B");
  v5 = JOptionPane.showInputDialog("Enter x3 for point C");
  v6 = JOptionPane.showInputDialog("Enter y3 for point C");
  x1 = Integer.parseInt(v1);
  y1 = Integer.parseInt(v2);
  x2 = Integer.parseInt(v3);
  y2 = Integer.parseInt(v4);
  x3 = Integer.parseInt(v5);
  y3 = Integer.parseInt(v6);

  Triangle tri = new Triangle();
  //set all needed data
  tri.setLengthA(x2,x3);
  tri.setLengthB(x3,x1);
  tri.setLengthC(x2,x1);
  tri.setHeight(y3,y1);
  // set calculations off the data
  tri.setAngleA();
  tri.setAngleB();
  tri.setAngleC();

  double perimeter = tri.calcPerimeter();

  double area = tri.calcArea();

  System.out.printf("Set up triangle with coordinates (" + x1 + "," + y1 + "), (" + x2 + "," + y2 + "), (" + x3 + "," + y3 + ")");
  System.out.printf("\nArea:\t\t\t\t" + area);
  System.out.printf("\nPerimeter:\t\t" + perimeter);
  System.out.printf("\nLength side a:\t" + tri.lengthA);
  System.out.printf("\nLength side b:\t" + tri.lengthB);
  System.out.printf("\nLength side c:\t" + tri.lengthC);
  System.out.printf("\nHeight h:\t\t" + tri.height);
  System.out.printf("\nAngle A:\t\t\t" + tri.angleA);
  System.out.printf("\nAngle B:\t\t\t" + tri.angleB);
  System.out.printf("\nAngle C:\t\t\t" + tri.angleC);

}
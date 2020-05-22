import java.util.Scanner;

public class DistanceCalcEasy
{
   public static void main(String[] args)
   {
   // Creating a new scanner object
   System.out.println("Distance Calculator");
   Scanner input = new Scanner(System.in);

   // Getting all of the coordinates
   System.out.print("Enter the X,Y coordinate of the first point: ");
   String xy1in = input.nextLine();

   System.out.print("Enter the X,Y coordinate of the second point: ");
   String xy2in = input.nextLine();

   String[] xy1 = xy1in.split(",");
   String[] xy2 = xy2in.split(",");

   double x1 = Double.parseDouble(xy1[0]);
   double y1 = Double.parseDouble(xy1[1]);
   double x2 = Double.parseDouble(xy2[0]);
   double y2 = Double.parseDouble(xy2[1]);

   // Calculating the distance between the points
   double distance = Math.sqrt( Math.pow((x2-x1),2) + Math.pow((y2-y1),2) );

   // Printing the distance to the User
   System.out.println("The distance between the points is " + distance);
   }
}
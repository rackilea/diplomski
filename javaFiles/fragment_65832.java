import java.util.Scanner;


public class MyShapes 
{
    public static Scanner scan = new Scanner(System.in);

    public static int Menu()
    {
        System.out.println("\nSelect a Shape or Exit: \n");
        System.out.println("1. Square");
        System.out.println("2. Circle");
        System.out.println("3. Triangle");
        System.out.println("4. Exit");

        System.out.println("\nEnter choice:");
        int option = scan.nextInt();

        return option;
    }// end menu

    public static void main(String[] args) 
    {       
        int option = 0;

        while (option != 4)
        {
            option = Menu();

            Shape shape = ShapeFactory.createShape(option); 
            printShape(shape); //check null needed.
        }
    }

    private void printShape(Shape shape){
        if(shape != null){
            double boundaryLength1 = shape.getBoundaryLength();
            double area1 = shape.getArea();
            System.out.println("Boundary Length = " + Math.round(boundaryLength1));
            System.out.println("Area = " + Math.round(area1));
        }
    }
}
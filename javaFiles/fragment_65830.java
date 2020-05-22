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

            Shape shape = null; 

            switch(option)
            {
                case 1:
                    shape = new Circle(scan.nextDouble());
                    break;

                case 2:
                    Shape shape = new Square(scan.nextDouble());
                    break;
                case 3:
                    shape = new Triangle(scan.nextDouble());
                    break;

                case 4:
                    System.out.println("System closing");
                    System.out.println("-----------\n");
                    //System.exit(0);   <-- not needed
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("--------------\n");
            }
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
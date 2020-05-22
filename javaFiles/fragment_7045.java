import java.util.Scanner;

public class BoxTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter length: ");
        double length = input.nextDouble();

        System.out.print("Enter width: ");
        double width = input.nextDouble();

        System.out.print("Enter heigth: ");
        double height = input.nextDouble();

        Box[] boxes = new Box[4];

        Box box1 = new Box(length, width, height);
        boxes[0] = box1;

        Box box2 = new Box();
        boxes[1] = box2;

        Box box3 = new Box(2.0, 3.5, 5.75);
        boxes[2] = box3;

        Box box4 = new Box(9.0, 12.0, 15.0);
        boxes[3] = box4;

        System.out.println(box1);
    }
}
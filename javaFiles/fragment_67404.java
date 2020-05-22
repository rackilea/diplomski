import java.util.Scanner;

public class Testing 
{
    public void input1()
    {
        Scanner user_input = new Scanner( System.in );

        System.out.print("(Don't put capital letters) ");

        String color;
        System.out.print("Enter Your Favorite Color: ");
        color = user_input.next();

        String animal;
        System.out.print("Enter Your Favorite Animal: ");
        animal = user_input.next();

        String preference;
        preference = color + " and that your favorite animal is a " + animal;

        System.out.println("From the information I gathered, I figured out that you like the color " + preference);
    }

    public void input2()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to hear a joke?");
        String a = input.next();

        if(a.equalsIgnoreCase("yes"))
        {
            System.out.println("What did the fish say when he ran into a wall? Dam");
        }
        else if(a.equalsIgnoreCase("no"))
        {
            System.out.println("Oh...");
        }
    }

    public static void main(String[] args)
    {
        Testing tS = new Testing();
        tS.input1();
        tS.input2();
    }
}
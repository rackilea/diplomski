import java.util.Scanner;

/** * * @author jodh_ */

public class ArrayExample
{

public static void main(String args[])
{
    String[] course = new String[5];

    for (int i = 0; i < 5; i++)
    {

        System.out.println("Please enter course name " + (i + 1) + ": ");
        Scanner gettingname = new Scanner(System.in);
        String coursenames = gettingname.nextLine();
        course[i] = coursenames;

        if (i < 4)
        {
            for(int j =0; j<4; j++)
            {
                System.out.println("");
                System.out.println("Would you like to continue? ((y)Yes / (n)No)");
                Scanner gettingYesOrNo = new Scanner(System.in);
                String input = gettingYesOrNo.nextLine();

                if (input.equals("yes") || input.equals("y") || input.equals("Y") || input.equals("YES") || input.equals("Yes"))
                {
                    System.out.println("");
                    break;

                }
                else if (input.equals("no") || input.equals("No") || input.equals("NO") || input.equals("n") || input.equals("N"))
                {
                    System.out.println("Your select courses are as follows");
                    for (int x = 0; x < i + 1; x++)
                    {
                        System.out.println("");
                        System.out.println((x + 1) + ": " + course[x]);
                    }
                    System.exit(0);
                }
                else
                {
                    System.out.println("Invalid input!! Please try again");
                    j--;
                }
            }
        }
    }
    System.out.println("Your select courses are as follows");
    for (int x = 0; x < 5; x++)
    {
        System.out.println("");
        System.out.println((x + 1) + ": " + course[x]);
    }
}
}
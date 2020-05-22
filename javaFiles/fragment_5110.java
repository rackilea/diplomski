import java.util.Scanner;
import java.lang.Math;

class BrockTaylor
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome. What is your name?");
        String x;
        x = scan.nextLine();
        System.out.println("Hello " + x + ". Try your best to crack the code!");
        System.out.println(" ");
        System.out.println("PHASE 1");
        System.out.println("Enter a number:");
        int y = scan.nextInt();
        // consume the /n
        scan.nextLine();
        //Phase 1
        if (y == 3)
        {
            System.out.println("Correct!");
            System.out.println(" ");
            System.out.println("PHASE 2");
            System.out.println("Enter a number:");
            int z = scan.nextInt();
            // consume the /n
            scan.nextLine();
            //Phase 2
            if (z == 1 || z >= 33 && z <= 100)
            {
                System.out.println("Correct!");
                System.out.println(" ");
                System.out.println("PHASE 3");
                System.out.println("Enter a number:");
                int c = scan.nextInt();
                // consume the /n
                scan.nextLine();
                //Phase 3
                if (c % 3 == 0 || c % 7 == 0)
                {
                    System.out.println("Correct!");
                    System.out.println("You have cracked the code!");
                }
                else // phase 3
                {
                    System.out.println("Sorry, that was incorrect!");
                    System.out.println("Better luck next time!");
                }
            }
            else // phase 2
            {
                System.out.println("Sorry, that was incorrect!");
                System.out.println("Better luck next time!");
            }
        }
        else// phase 1
        {
        System.out.println("Sorry, that was incorrect!");
        System.out.println("Better luck next time!");
        }
    }
}
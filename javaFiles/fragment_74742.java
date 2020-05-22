import java.util.Scanner;

/*Author:
  Date:
  Program: Write a class "Plumbers" that handles emergency plumbing calls. The company handles natural floods and burst pipes. If the customer selects a flood, the program must prompt the user to determine the amount of damage for pricing. Flood charging is based on the numbers of damaged rooms. 1 room costs $300.00, 2 rooms cost $500.00, and 3 or more rooms cost $750.00. Pipe bursting is based on the number of pipes: 1 pipe costs $50.00, 2 pipes cost $70.00, and 3 or more pipes cost $100.00
  */

public class Plumbers


{

    public static void main(String[] args)
    {
        //Declarations

        //double totalCost;
        int answer;
        int floAnswer;
        int pipeAnswer;
        // Declare flood room damage cost: 1 room costs $300.00, 2 rooms cost $500.00, and 3 or more rooms cost $750.00
        double[] floRoom = {300.00,500.00,750}; 

        // Delcare pipe burst damage by number of pipes: 1 pipe costs $50.00, 2 pipes cost $70.00, and 3 or more pipes cost $100.00
        double[] pipeDam = {50.00,70.00,100.00};

        Scanner scan = new Scanner(System.in);
        System.out.print("Press 1 if a flood or burst pipes occured or Press 2 for other options: ");
        answer = scan.nextInt();

        switch (answer)
        {
            case 1:

                System.out.print("How many rooms were affected by flood damage 1, 2, 3 or more?: ");
                floAnswer = scan.nextInt();
                if (floAnswer > 3) floAnswer = 3;

                System.out.print("How many pipes are damaged? 1, 2, 3 or more?: ");
                pipeAnswer = scan.nextInt();
                if (pipeAnswer > 3) pipeAnswer = 3;

                double totalCost = floRoom[floAnswer] + pipeDam[pipeAnswer];
                System.out.println("Total cost of visit: $" +totalCost);

                break;

            case 2:
                System.out.println("Please contact your local office as this number only handles emergency calls, Thank you.");//exit from program;
                break;

            default :
                System.out.println("invalid choice")   ;
                break;
        }



    }

}// end of class
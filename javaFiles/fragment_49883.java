import java.util.Scanner;

public class Planetweight {

      public static void main(String[] args) {
        System.out.println(" ===== How much do I weigh on other planets? =====\n");
        weight();
        planetSelection();
    }

    static double weightlbs;
    static double weightkg;
    static int planetNumber;

    public static void weight() {
        boolean exit = false;
        Scanner in = new Scanner(System.in);
        System.out.println("\n1). Please type 1 and press enter, to know the weight in pounds." + "\n2). Please type 2 and press enter, to know the weight in kg." + "\n3). Please type 3 to exit this program.");
        int choice = in.nextInt();
        if (choice == 1)
        {
          System.out.println("You have chosen weight in lbs, please enter your current weight in pounds.");
          weightlbs = in.nextDouble();
        }
        if (choice == 2)
        {
          System.out.println("You have chosen weight in kg, please enter your weight in kilograms.");
          weightkg = in.nextDouble();
        }
        if (choice == 3)
        {
          System.out.println("Ooops.. Something is not quite right, please try again later!");
          exit = true;
        }
    }

    public static void planetSelection()     {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose a Planet in our Solar System: \n 1). Mercury \n 2). Venus \n 3). Earth \n 4). Moon \n 5). Mars \n 6). Jupiter \n 7). Saturn \n 8). Uranus \n 9). Neptune \n 10). Pluto \n Select one planet from (1-10");
        int choice = in.nextInt();
        if (choice == 1)
        {
            System.out.printf("Your weight on Mercury is: %.1f lbs", (weightlbs * 0.4155));
            weight();
        }
    }
}
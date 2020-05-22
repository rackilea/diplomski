import java.util.Scanner;

public class Lab4_5 {
static Scanner keyboard = new Scanner(System.in);

// Declare local variables
static double totalBurger, totalFry, totalSoda, calcTotal;
static int option, burgerCount, fryCount, sodaCount;

// The main method
public static void main(String[] args) {

    //Add a loop to run program again
    String endProgram = "no";
    while (endProgram.equals("no")){

        //Add a loop to take in order
        String endOrder = "no";
        while (endOrder.equals("no")){

        // Add statements to display the menu, get the user choice, and assign it to option
            System.out.println("Enter 1 for Yum Yum Burger");
            System.out.println("Enter 2 for Grease Yum Fires");
            System.out.println("Enter 3 for Soda Yum");

            //Add a Select Case statement based on the value of option
            int option = 0;
            option = keyboard.nextInt();

            //When option = 1
            if (option == 1){
                totalBurger = 0;
                burgerCount = 0;
                System.out.println("Enter the number of burgers you want ");
                burgerCount = keyboard.nextInt();
                totalBurger = totalBurger + burgerCount * .99;
            }   
            //When option = 2
            if (option == 2){
                System.out.println("Enter the number of fires you want ");
                fryCount = keyboard.nextInt();
                totalFry = totalFry + fryCount * .79;
            }   
            //When option = 3
            if (option == 3){
                System.out.println("Enter the number of sodas you want ");
                sodaCount = keyboard.nextInt();
                totalSoda = totalSoda + sodaCount * 1.09;
            }   

            //Imput if user wants to end order
            System.out.println("Do you want to end your order? (Enter no to add more items ) ");
            endOrder = keyboard.next();
       }

        calcTotal();
        printReceipt();

      //Ask user if they want to end the program
        System.out.println("Do you want to end the program? (Enter no to process a new order) ");
        endProgram = keyboard.next();
    }
}

  //Calculate the total amount
  public static void calcTotal() {

      //Add statements to calc total with tax and call printReceipt
      calcTotal = totalBurger + totalFry + totalSoda * .06;
  }

 public static void printReceipt() {
    //Add statements to display the total as shown above
    System.out.println("Your total is $" + calcTotal);
  }
}
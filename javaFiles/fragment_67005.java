import java.util.Scanner;

public class CarWash {
  public static void main(String[] args)
  {

    Scanner keyboard = new Scanner(System.in);
    String name = " ";
    String runProgram = " ";
    int washType = 0;
    char carType = ' ';
    char extras = ' ';
    double basicPrice = 0.0;
    double adder = 0.0;
    double extraPrice = 0.0;
    double totalPrice = 0.0;
    final double SHINE_PRICE = 4.95;
    final double MAT_PRICE = 8.95;
    final double CWAX = 7.95;

    System.out.println("Welcome to the Car Wsh");
    System.out.println("Enter Yes to start the program or No to quit.");
    runProgram = keyboard.nextLine();
    runProgram = runProgram.toLowerCase();

    while (runProgram.equals("yes"))
    {

      //Getting user input
      System.out.println("Please enter your name");
      name = keyboard.nextLine();

      System.out.println("Please choose the type of car wash:");
      System.out.println("1.  Pleasant Colony - sedan $34.95 SUV $35.95");
      System.out.println("2.  Secretariat - sedan $24.95 SUV $25.95");
      System.out.println("3.  Gallant Fox - sedan $19.95 SUV $20.95");
      System.out.println("4.  Pony Express - sedan $14.95 SUV $15.95");
      System.out.println("5.  Win - $12.95");
      System.out.println("6.  Show - $8.95");
      washType = keyboard.nextInt();
      keyboard.nextLine();

      //Input validation loop for washType

      while (washType < 1 || washType > 6) //this works
      //while (washType != 1 && washType !=2 && washType !=3 && washType !=4 && washType !=5 && washType != 6)//This works
      {

        System.out.println("Invalid data.");
        System.out.println("Please enter a value from 1 to 6.");
        washType = keyboard.nextInt();
        keyboard.nextLine();

      }//end washType while

      System.out.println("Please enter a S for Sedan or V for SUV.");
      carType = keyboard.nextLine().charAt(0);
      carType = Character.toUpperCase(carType);

      //validation method for carType
      validateCarType(carType);

      //below presents 2 different menus to the user for extras
      if (washType == 1 || washType == 2)
      {

        System.out.println("Please choose the extras:");
        System.out.println("A.  No Extras $0.00");
        System.out.println("B.  Mat Shampoo $8.95");
        System.out.println("C.  Carnauba Wax $7.95");
        System.out.println("D.  Both Mat Shampoo and Carnauba Wax $16.90"); //On the BB document, you put E, so I changed it to D

      }//end washType if

      else
      {

        System.out.println("Please choose the extras:");
        System.out.println("A.  No Extras $0.00");
        System.out.println("B.  Mat Shampoo $8.95");
        System.out.println("C.  Carnauba Wax $7.95");
        System.out.println("D.  Tire Shine $4.95");
        System.out.println("E.  Both Mat Shampoo and Carnauba Wax $16.90");
        System.out.println("F.  Both Mat Shampoo and tire Shine $13.90");
        System.out.println("G.  Both Carnauba Wax and Tire Shine $12.90");
        System.out.println("H.  All: Mat Shampoo and Carnauba Wax and Tire Shine $21.85");

      }//end else

      extras = keyboard.nextLine().charAt(0);
      extras = Character.toUpperCase(extras);

      //Validation loop for extras

      while (extras != 'A' && extras != 'B' && extras != 'C' && extras != 'D' && extras != 'E' && extras != 'F' && extras != 'G' && extras != 'H') //This works
      {

        System.out.println("Invalid data.");
        System.out.println("Please enter either A, B, C, D, E, F, G, or H.");
        extras = keyboard.nextLine().charAt(0);
        extras = Character.toUpperCase(extras);

      }//end Invalid extras while

      //determines basicPrice based on washType
      basicPrice = setBasicPrice(washType);

      //determines adder based on carType
      adder = setAdderPrice(carType);

      //determines extraPrice based on extras
      switch (extras)
      {

        case 'A':
          extraPrice = 0.0;
          break;
        case 'B':
          extraPrice = MAT_PRICE; //extraPrice = 8.95;
          break;
        case 'C':
          extraPrice = CWAX; //extraPrice = 7.95;
          break;
        case 'D':
          extraPrice = SHINE_PRICE;
          break;
        case 'E':
          extraPrice = 16.90;
          break;
        case 'F':
          extraPrice = 13.90;
          break;
        case 'G':
          extraPrice = 12.90;
        case 'H':
          extraPrice = 21.85;
          break;
        default:
          extraPrice = 0.0;
          break;

      }//end extras switch

      //method to calculate totalPrice
      totalPrice = calcTotalPrice(basicPrice, adder, extraPrice);

      //method to print a horizontal line of characters
      printLineOfChars('*', 60);

      //method to display results
      displayResults(name, washType, carType, basicPrice, adder, extraPrice, totalPrice);

      //method to print a horizontal line of characters
      printLineOfChars('*', 60);

      //give the user a chance to run the program again or quit
      System.out.println("Please enter Yes to run the program again or No to quit.");
      runProgram = keyboard.nextLine();
      runProgram = runProgram.toLowerCase();

    }//end runProgram while

    System.out.println("Thanks for using the Car Wash Program.");

  }//end main

  private static void validateCarType(char carType) {
  }

  //calctotalPrice method calculates the total price
  public static double calcTotalPrice(double myBasicPrice, double myAdder, double myExtraPrice)
  {
    double myTotalPrice = 0.0;

    myTotalPrice = myBasicPrice + myAdder + myExtraPrice;

    return myTotalPrice;

  }//end double calcTotalPrice() method

  //printLineOfChars method prints a horizozntal line of chars
  public static void printLineOfChars(char myCharacter, int myLoopCounter)
  {

    for (int i = 0; i <= myLoopCounter; i++)
    {

      System.out.print(myCharacter);

    }//end for

    System.out.println();

  }//end printLineOfChars()

  public static void displayResults(String myName, int myWashType, char myCarType, double myBasicPrice, double myAdder, double myExtraPrice, double myTotalPrice)
  {

    //display results
    System.out.printf("%-35s%10s\n", "Customer Name", myName);
    System.out.printf("%-35s%10s\n", "Car Wash Chosen", myWashType);
    System.out.printf("%-35s%10s\n", "Car Type", myCarType);
    System.out.printf("%-35s%10.2f\n", "Basic Price: ", myBasicPrice);
    System.out.printf("%-35s%10.2f\n", "Adder: ", myAdder);
    System.out.printf("%-35s%10.2f\n", "Extras: ", myExtraPrice);
    System.out.printf("%-35s%10.2f\n", "Total Price: ", myTotalPrice);

  }//end displayresults() method

  //setAdderPrice method calculates the adder
  public static double setAdderPrice(char myCarType)
  {

    double myAdder = 0.0;
    if (myCarType == 'S')
    {

      myAdder = 0.00;

    }//end if

    else
    {

      myAdder = 1.00;

    }//end else

    return myAdder;

  }//end setAdderPrice() method

  //setBasicPrice method sets the basic price based on washType
  public static double setBasicPrice(int myWashType)
  {

    double myBasicPrice = 0.0;
    switch (myWashType)
    {

      case 1:
        myBasicPrice = 34.95;
        break;
      case 2:
        myBasicPrice = 24.95;
        break;
      case 3:
        myBasicPrice = 19.95;
        break;
      case 4:
        myBasicPrice = 14.95;
        break;
      case 5:
        myBasicPrice = 12.95;
        break;
      case 6:
        myBasicPrice = 8.95;
        break;
      default:
        myBasicPrice = 0.0;

    }//end Swtich (myWashType)

    return myBasicPrice;

  }//end setBasicPrice() method

}
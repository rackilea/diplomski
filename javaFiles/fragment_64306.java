import java.util.Scanner;

class Mark_UserInputTask {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); //Declare the one scanner for the whole program

    System.out.print("Please enter your first integer: "); //Prompt the user for input
    int var1 = scanner.nextInt(); //Store the users input if it is an integer in a variable
    System.out.print("Please enter your second integer: "); 
    int var2 = scanner.nextInt(); 

    if (var1 == var2) { //test if both variables are equal
      System.out.println(var1 + " is equal to " + var2);
    } else {
      System.out.println(var1 + " is not equal " + var2);
    }
  }
}
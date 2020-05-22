import java.util.Scanner;

// Always capitalize your public class name (and the corresponding source file)
public class Number{

  public static void main(String[] args){
    // Get #/employees
    int numEmployee = Number.workers();
    System.out.println ("#/employees=" + numEmployee);
  }

  public static int workers(){
    // Loop until we get a valid number
    int number;
    do {
      System.out.println("How many employees do you have?");  
      Scanner input = new Scanner(System.in);
      number = input.nextInt();
    } while (number <= 0)

    // Return the final value
    return number;
  }
}
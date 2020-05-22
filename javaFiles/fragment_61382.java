import java.util.Scanner;
import java.util.Random;
public class lottery
{
  public static void main (String [] args)
  {
    Scanner input=new Scanner(System.in);
    System.out.println("Please enter your number");
    Random randomNumber=new Random();
    int rand = randomNumber.nextInt(10) + 1
    System.out.println(" my random number is "+65);
    System.out.println("lotto number is "+ rand);
    if(rand == 65)
      System.out.println("You win 20000");
    else if(rand == 56)
      System.out.println("You win 10000");
    else if(rand == 6 || rand == 5)
      System.out.println("You win 5000");
    else
      System.out.println("No winner");
  }
}
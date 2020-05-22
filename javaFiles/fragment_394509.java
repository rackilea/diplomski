import java.util.Scanner;

public class FreezingBoilingTester
{
  public static void main(String[] args)
  {

    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter a temperature: ");
    int temperature = scan.nextInt();

    FreezingBoilingPoints temp1 = new FreezingBoilingPoints(temperature );
    System.out.println(temp1.showTempinfo());
  }
}
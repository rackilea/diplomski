import java.util.Scanner;

public class FahrenheittoCelsius {

  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("If you would like to convert a temperature from Fahrenheit to Celcius, enter 1.");
      System.out.println("If you would like to convert a temperature from Celcius to Fahrenheit, enter 2.");
      int mode = scan.nextInt();
      if (mode == 1)
      {   
          System.out.println("Enter the temperature in Fahrenheit");
          int Ftemp = scan.nextInt();
          int Cnewtemp = (Ftemp - 32) * 5 / 9;
          System.out.println("The temperature in Celcius is " + Cnewtemp + " degrees.");
       }
      if (mode == 2)
      {   
          System.out.println("Enter the temperature in Celcius");
          int Ctemp = scan.nextInt();
          int Fnewtemp = Ctemp * 9 / 5 + 32;
          System.out.println("The temperature in Fahrenheit is " + Fnewtemp + " degrees.");   
      }       
  }

}
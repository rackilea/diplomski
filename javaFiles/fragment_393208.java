import java.util.Scanner;

public class Pilot
{

  public static void main(String args[])
  {
    Scanner kb = new Scanner(System.in);


    double Altitude = 10.0;

    String Name = "Eagle";

    double fuelLeft = 1000.0;

    int shipWeight = 400;

    int maxThrust = 10000;

    int verticalSpeed = 0;

    double efficiency = 0;

    int maxFuel = 400; //max fuel flow

    LunarLander lander = new LunarLander(Altitude, verticalSpeed, fuelLeft); // create a LunarLander object

    System.out.println("Initial data: ");
    System.out.println("Altitude = " + Altitude);
    System.out.println("Speed = " + verticalSpeed);
    System.out.println("Fuel = " + fuelLeft);

    while (lander.crashed() != true && Altitude > 0)
    {

      System.out.println("Please enter a time in seconds: ");
      int time = kb.nextInt();
      System.out.println("Please enter a fuel rate between 0 and 1");
      double inputFuelRate = kb.nextDouble();
      System.out.println("Input time increment: " + time);
      System.out.println("Input fuel rate: " + inputFuelRate);

      lander.move(efficiency, maxFuel, time, inputFuelRate);


      System.out.println(lander.toString());
    }

  }
}
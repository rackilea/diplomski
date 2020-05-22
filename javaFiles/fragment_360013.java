import java.util.Scanner;

class Main
{
  public static void main(String[] args)
  {
    int count = 2;
    String[] names = new String[count];
    double[] avgs = new double[count];
    readData(names, avgs, count);
    System.out.println("names[0] in main: " + names[0]);
  }

  public static void readData(
    String[] playerNames,
    double[] battingAvg,
    int numPlayers
  )
  {
    Scanner in = new Scanner(System.in);
    // no array allocated this time
    for (int i = 0; i < numPlayers; i++)
    {
      System.out.print("Players name: ");
      String line = in.nextLine();
      // put the value into the array that was passed
      playerNames[i] = line.trim();
    }
    System.out.println("playerNames[0] in readData: " + playerNames[0]);
  }
}
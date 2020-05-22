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
    // allocating a new array
    String[] playerNames2 = new String[numPlayers];
    for (int i = 0; i < numPlayers; i++)
    {
      System.out.print("Players name: ");
      String line = in.nextLine();
      // putting the value into the newly allocated array
      playerNames2[i] = line.trim();
    }
    System.out.println("playerNames2[0] in readData: " + playerNames2[0]);
  }
}
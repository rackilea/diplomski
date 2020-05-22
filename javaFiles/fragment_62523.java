import java.util.*;

public class RandomClass
{

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        String name;
        int num;

        PlayerInfo[] players = new PlayerInfo[4];

        // Ask how many players will play
        System.out.print("How many players(4 max) : ");
        int value = input.nextInt();

        while (true) 
        {
            // Players need to be 1-4 max
            if (value <= 4 && value >= 1) {
                System.out.println("You have " + value + " players");
                break;
                // Cannot be less than 1
            } else if (value < 1) {
                System.out.println("(You cannot have less than 1 player)");
                System.out.println("Please Try again : ");
                value = input.nextInt();
                // Cannot be more than 4
            } else if (value > 4) {
                System.out.println("(You cannot have more than 4 players)");
                System.out.println("Please try again :");
                value = input.nextInt();
            }
        }

        for (int i = 0; i < value; i++) 
        {
            System.out.println("Player" + (i + 1) + " Please Enter your name : ");
            String PlayerName = input.next();
            System.out.println("Please enter your number : ");
            int PlayerNumber = input.nextInt();

            players[i] = new PlayerInfo(PlayerName, PlayerNumber);

        }

        System.out.println();

        for (int i = 0; i < value; i++)
        {
            System.out.println(players[i].getName());
            System.out.println(players[i].getNum());
            System.out.println();
        }
    }
}

class PlayerInfo
{
    // variables
    private String name;
    private int num;

    // constructors
    public PlayerInfo() {}

    public PlayerInfo (String xname, int xnum)
    {
        name = xname;
        num = xnum;
    }

    // methods
    public String getName()
    {
        return name;
    }

    public int getNum()
    {
        return num;
    }
}
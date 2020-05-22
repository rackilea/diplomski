import java.util.*;

public class game
{
    //holds a list of all players.
    ArrayList<Player> allPlayers = new ArrayList<Player>();
    //holds a list of players older than 30 years.
    ArrayList<Player> olderThan30 = new ArrayList<Player>();

    public game()
    {
        //read players list and fill in the above arraylist with all players you have.
        //for example, allPlayers = getAllPlayers(); You can also use IO methods to read external files.
        //get all players that is older than 30 years of age by calling a method get30OlderPlayers().
        olderThan30 = get30OlderPlayers();
    }

    private ArrayList<Player> get30OlderPlayers()
    {
        //an arraylist that will save the player list to return.
        ArrayList<Player> olderThan30 = new ArrayList<Player>();

        //loops through all players one by one.
        for (Player p : allPlayers)
        {
            //if the player's age is more than 30....
            if(p.getAge() > 30)
            {
                //...add it to the arraylist olderThan30.
                olderThan30.add(p);
            }
        }
        //at the end return the arraylist that holds the players older than 30.
        return olderThan30;
    }
}
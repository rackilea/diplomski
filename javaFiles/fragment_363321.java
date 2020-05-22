import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Console
{

    public static void main ( String [ ] args )
    {
        List < Player > players = new ArrayList< Player >();
        List < Player > playersOrdered = new ArrayList < Player > ( );

        players.add ( new Player ( "Chris", 32222 ) );
        players.add ( new Player ( "John", 3 ) );
        players.add ( new Player ( "Zebra", 5 ) );
        players.add ( new Player ( "Albert", 333 ) );
        players.add ( new Player ( "Chris", 32222 ) );
        players.add ( new Player ( "Chris", 3 ) );



        Collections.sort ( players, new ComparatorPlayer ( ) );



        for ( Player player : players )
        {
            System.out.println ( player.getName ( ) +  " + " + player.getHandicap ( ) );
            playersOrdered.add ( player );
        }

    }

}
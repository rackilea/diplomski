import java.util.ArrayList;

public class Console
{

    public static void main ( String [ ] args )
    {
        System.out.println ( "Starting" );
        ArrayList < Player > players = new ArrayList < Player > ( );
        players.add ( new Player ( "John" , 3 ) );
        players.add ( new Player ( "Chris" , 32222 ) );
        players.add ( new Player ( "Zebra" , 5 ) );
        players.add ( new Player ( "Albert" , 333 ) );
        players.add ( new Player ( "Christ" , 32222 ) );
        players.add ( new Player ( "Chris" , 3 ) );

        alphabeticSort ( players );

        for ( Player player : players )
        {
            System.out.println ( player.getName ( ) + " + " + player.getHandicap ( ) );
        }

        System.out.println ( "Finish" );
    }

    // alphabeticSort pass by parameter
    public static void  alphabeticSort ( ArrayList < Player > players )
    {
        int i = 1 , j;
        Player key = new Player ( );
        ArrayList < Player > inputArray = players;

        for ( j = 1 ; j < inputArray.size ( ) ; j ++ )
        {
            key = inputArray.get ( j );
            i = j - 1;

            while ( i >= 0 )
            {
                if ( key.getName ( ).compareTo ( inputArray.get ( i ).getName ( ) ) > 0 )
                {
                    break;
                }

                Player element = inputArray.get ( i + 1 );
                inputArray.set ( i + 1 , inputArray.get ( i ) );
                inputArray.set ( i , element );
                i -- ;
            }
        }
    }
}
import java.util.ArrayList;

public class Tournament
{

    int [] scores;
    ArrayList<Player> players = new ArrayList<Player> ( );
    int [] pars;

    public Tournament ( int [ ] par )
    {
        this.pars = par;
    }

    /**
     * @return the scores
     */
    public int [ ] getScores ( )
    {
        return scores;
    }

    /**
     * @param scores the scores to set
     */
    public void setScores ( int [ ] scores )
    {
        this.scores = scores;
    }

    /**
     * @return the players
     */
    public ArrayList < Player > getPlayers ( )
    {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers ( ArrayList < Player > players )
    {
        this.players = players;
    }

    /**
     * @return the pars
     */
    public int [ ] getPars ( )
    {
        return pars;
    }

    /**
     * @param pars the pars to set
     */
    public void setPars ( int [ ] pars )
    {
        this.pars = pars;
    }

    /**
     * Enter a player to a tournament
     * @param name
     * @param handicap
     * @param scores
     */
    public void enter ( String name , int handicap , int [ ] scores )
    {
        this.players.add ( new Player ( name, handicap, scores ));
    }


    /**
     * alphabeticSort by player name
     */
    public void alphabeticSort ()
    {
        int i = 1 , j;
        Player key = new Player ( );
        ArrayList < Player > inputArray = this.getPlayers ( );

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
       this.players = inputArray;
    }

}
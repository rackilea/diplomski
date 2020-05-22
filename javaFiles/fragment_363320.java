import java.util.Comparator;

public class ComparatorPlayer implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2)
    {
        if( p1.getName ( ).compareTo ( p2.getName ( ) ) < 0 )
        {
            return -1;
        }
        else if ( p1.getName ( ).compareTo ( p2.getName ( ) ) > 0 )
        {
            return 1;
        }
        return 0;
    }


}
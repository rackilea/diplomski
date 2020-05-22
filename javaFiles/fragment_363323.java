import java.util.Arrays;

public class Player
{
    private String name;
    private int handicap;
    private int scores[];

    public Player( )
    {

    }

    public Player (String name, int handicap)
    {
        this.name = name;
        this.handicap = handicap;
    }

    public Player (String name, int handicap, int [] scores)
    {
        this.name = name;
        this.handicap = handicap;
        this.setScores ( scores ); 
    }

    /**
     * @return the name
     */
    public String getName ( )
    {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName ( String name )
    {
        this.name = name;
    }
    /**
     * @return the handicap
     */
    public int getHandicap ( )
    {
        return handicap;
    }
    /**
     * @param handicap the handicap to set
     */
    public void setHandicap ( int handicap )
    {
        this.handicap = handicap;
    }

    /**
     * @return the scores
     */
    public int [] getScores ( )
    {
        return scores;
    }

    /**
     * @param scores the scores to set
     */
    public void setScores ( int scores[] )
    {
        this.scores = scores;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode ( )
    {
        // TODO Auto-generated method stub
        return super.hashCode ( );
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        Player objToCompare = (Player) obj;
        if( this.handicap == objToCompare.getHandicap ( ) &&
                this.name.equals ( objToCompare.getName ( ) ) &&
                    Arrays.equals ( this.scores , objToCompare.scores ))
        {
            return true;
        }
        return false;

    }

}
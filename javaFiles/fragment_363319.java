public class Player
{
    private String name;
    private int handicap;

    public Player (String name, int handicap)
    {
        this.name = name;
        this.handicap = handicap;
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
}
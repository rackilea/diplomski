class BaseballStats {

private String filename;

public BaseballStats ( String filename )
{
    this.filename = filename;
}

public String getTeamName( )
{
//accessor for teamName
}

public void setTeamName( String newTeamName )
{
//mutator for teamName
}

public double maxAverage( )
{
//returns the highest batting average
}
public double minAverage( )
{
//returns the lowest batting average
}

public double spread( )
{
//returns the difference between the highest and lowest batting averages
}

public int goodPlayers( )
{
//returns the number of players with an average higher than .300
}

public String toString( )
{
//returns a String containing the team name followed by all the batting averages formatted to three decimal places. 
}
}
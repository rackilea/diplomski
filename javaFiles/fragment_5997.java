public class SeasonResults{
private String hometeam;
private String awayteam;
private String result;                                          

public String getHometeam() {
    return hometeam;
}
public void setHometeam(String hometeam) {
    this.hometeam = hometeam;
}
public String getAwayteam() {
    return awayteam;
}
public void setAwayteam(String awayteam) {
    this.awayteam = awayteam;
}
public String getResult() {
    return result;
}
public void setResult(String result) {
    this.result = result;
}

public  SeasonResults(String hometeam, String awayteam, String result) 
{
    this.hometeam = hometeam;
    this.awayteam = awayteam;
    this.result = result;
}
@Override
public String toString() 
{ 
    return " "+hometeam+", "+awayteam+", "+result; 
}

}
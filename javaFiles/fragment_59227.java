import java.io.*;
import java.util.*;

/**  
 * Class League - An instance of this class represents the teams in a
 * football (or similar) league. It provides a class method for creating
 * a new instance of League by reading the data for the teams from a CSV
 * file.
 * 
 * @author Lewis Jones 
 * @version 1.0
 */

public class League
{
   /* instance variables */
   private String name;  // The name of the league
   private Team[] teams; // An array to hold the teams in the league

   /**
    * Constructor for objects of class League. It sets the name of the league
    * to the String object provided as the first argument and initialises teams
    * to an array of the size provided as the second argument. This constructor 
    * is private as it is intended for use only by the class method loadLeague().
    */
   private League(String aName, Team[] teams)
   {
      super();
      this.name = aName;
      this.teams = teams;
   }

   /* class method */
   /**
    * This method creates a new League object by reading the required details from
    * a CSV file. The file must be organised as follows:
    *     name(String), number of teams (int)
    *     team name(String), won(int), drawn(int), lost(int), for(int), against    (int)
    *        and so on for each team
    * Having created the new League object the method should create all the Team 
    * objects (using the data in the file to set their attributes) and add them 
    * to the teams array.
    */
   public static League loadLeague()
   {
      League theLeague = null;
      String pathname = OUFileChooser.getFilename();
      File aFile = new File(pathname);
      Scanner bufferedScanner = null;

      try
      {
         String leagueName;
         int numberOfTeams;

         String teamName;
         int won;
         int drawn;
         int lost;
         int goalsFor;
         int goalsAgainst;
         Scanner lineScanner;
         String currentLine;
         bufferedScanner = new Scanner(new BufferedReader(new FileReader (aFile)));    
         boolean firstLine = true;
         List<Team> teamsList = new ArrayList<Team>();
         Team[] teams = null;
         while (bufferedScanner.hasNextLine())
         {
            currentLine = bufferedScanner.nextLine();
            lineScanner = new Scanner(currentLine);
            lineScanner.useDelimiter(",");

            if (firstLine) {
                // you originally used "bufferedScanner" which actually 
                // gets the values on the next line, not the current line
                leagueName = lineScanner.next();
                numberOfTeams = lineScanner.nextInt();
                firstLine = false;
                continue;
            }

            Team aTeam = new Team(lineScanner.next());
            aTeam.setWon(lineScanner.nextInt());
            aTeam.setDrawn(lineScanner.nextInt());
            aTeam.setLost(lineScanner.nextInt());
            aTeam.setGoalsFor(lineScanner.nextInt());
            aTeam.setGoalsAgainst(lineScanner.nextInt());
            teamsList.add(aTeam);

         }
         teams = teamsList.toArray(new Team[]{});
         theLeague = new League(leagueName, teams);
      }  
      catch (Exception anException)
      {
         System.out.println("Error: " + anException);
      }
      finally
      {
         try
         {
            bufferedScanner.close();
         }
         catch (Exception anException)
         {
            System.out.println("Error: " + anException);
         }
      }
      return theLeague;
   }

   /* instance methods */

   /**
    * Displays the league table in tabular format to the standard output
    */
   public void display()
   {
      System.out.println(this.name);
      System.out.format("%20s %2s %2s %2s %2s %2s %2s %    2s\n","","P","W","L","D","F","A","Pt");
      for (Team eachTeam : this.teams)
      {
         System.out.format("%20s %2d %2d %2d %2d %2d %2d %2d\n",
                       eachTeam.getName(), eachTeam.getPlayed(), 
                       eachTeam.getWon(), eachTeam.getDrawn(), 
                       eachTeam.getLost(),eachTeam.getGoalsFor(), 
                       eachTeam.getGoalsAgainst(), eachTeam.getPoints());        
      }
   }

   /**
    * Arrange the elements of teams in their natural order. This will only
    * work if a natural order has been defined for the class Team.
    */
   public void sort()
   {
      // to be written later...
   }
}
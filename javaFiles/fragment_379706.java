import java.io.*;
import java.util.ArrayList;

public class test {

  public static void main (String[] args) {
    test t = new test();
    t.test();
  }

  /** A test method for our code **/
  public void test(){
    String[] command = new String[2];

      BufferedReader commands = null;

      //initialize list of commands
      ArrayList<String[]> commandList = new ArrayList<String[]>();

      //Get a list of Commands from a file
      this.getCommands( commandList );

      //get the next command
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Next Thing?\n");
      this.getCommand( br, command, commandList );
      if ( command[1] == null ){
        System.out.print("New command?\n");
        commandList.add( this.makeCommand( br, command ) );
      }
      else{
        //Not sure what you want to do here, this is if the method IS found
        System.out.println( "We found: "+command[1]);
      }

      this.save(commandList);  
  }

  /**Returns the old list of commands**/
  public void getCommands( ArrayList<String[]> commandList ){
    BufferedReader commands;
    try{
      String sCurrentLine;

      commands = new BufferedReader(new FileReader("testing.txt"));

      while ((sCurrentLine = commands.readLine()) != null) {
        commandList.add( sCurrentLine.split(":") );
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
  Asks the user for a command and checks it against known commands. It's not a 
  very efficient algorithm, but effective. 
  **/
  public void getCommand( BufferedReader br, String[] command, 
                          ArrayList<String[]> commandList ){

    try {
      command[0] = br.readLine();
      for ( String[] com : commandList ){
        if (com[0].equals( command[0] )){
          command[1] = com[1];
        }
      }
    } 
    catch (IOException ioe) 
      {
       System.out.println("IO error trying to read your commnad!");
      }
  }

  /** Makes a new command, to be used when one isn't known **/
  public String[] makeCommand( BufferedReader br, String[] command ){
    try{
      command[1] = br.readLine();
    }
    catch( IOException ioe)
      {
        System.out.println("Oh no!!!");
      }
      return command;
  }

  /** Saves your stuff **/
  public void save( ArrayList<String[]> commandList){
    try{
      PrintWriter writer = new PrintWriter( "testing.txt","UTF-8" );
      for ( String[] com : commandList ){
        writer.println( com[0]+":"+com[1] );
      }
      writer.close();
    }
    catch( Exception ioe ){
      System.out.println("You're in trouble");
    }
  }


}
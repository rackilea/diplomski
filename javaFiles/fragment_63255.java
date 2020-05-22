public class Parser {

    public void parseFile (String file) {
       // parsing code goes here.
    }
    public static void main (String[] commandLineArgs) {
         Parser parser = new Parser();
         parser.parseFile(commandLineArgs[0]);   //  
    }

}
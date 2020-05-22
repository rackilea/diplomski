import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

class Rule {
   String  element;
   boolean skip;
}

class ElementParser {
   String[] comment;
   Rule[]   rules;
}

public class JSonDecoder {
   public static void main( String[] args ) throws IOException {
      try( BufferedReader reader =
              new BufferedReader( new FileReader( "Skip.json" ))) {
         System.out.println( 
            new Gson().fromJson( reader, ElementParser.class ).toString());
      }
   }
}
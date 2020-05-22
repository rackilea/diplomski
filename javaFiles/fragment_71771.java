import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

class Rule {
   String element;
   boolean skip;

   @Override public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append( '\t' );
      sb.append( element );
      sb.append( " ==> " );
      sb.append( skip );
      sb.append( '\n' );
      return sb.toString();
   }   
}
class ElementParser {
   String[] comment;
   Rule[]    rules;

   @Override public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append( "Comment:\n" );
      for( String c : comment ) {
         sb.append( '\t' );
         sb.append( c );
         sb.append( '\n' );
      }
      sb.append( "Rules:\n" );
      for( Rule r : rules ) {
         sb.append( r.toString());
      }
      return sb.toString();
   }
}

public class JSonDecoder {
   public static void main( String[] args ) throws IOException {
      try( BufferedReader reader = new BufferedReader( new FileReader( "Skip.json" ))) {
         System.out.println( 
            new Gson().fromJson( reader, ElementParser.class ).toString());
      }
   }
}
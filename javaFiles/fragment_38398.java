import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

   public static void main( String args[] ) {
      // String to be scanned to find the pattern.
      String line = "pro.itemDate=<'2/02/2018'> and pro.itemRate=0";
      String pattern = "[^\\s]+\\.[^\\s=]+";

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      while (m.find( )) {
         System.out.println("Found value: " + m.group(0) );
      }else {
         System.out.println("NO MATCH");
      }
   }
}
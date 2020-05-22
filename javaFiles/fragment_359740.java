import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexMatching {

    public static void main(String[] args) {
         Pattern p = Pattern.compile("([^=]+) ([^=]+ = [^:]+): (.+)");
         Matcher m = p.matcher("text, excluding the equals character ab = c d e = f g = h i: other text");

         if (m.find()) {
             //System.out.println(m.group(0));
             System.out.println(m.group(1));
             System.out.println(m.group(2));
             System.out.println(m.group(3));
         }
    }

}
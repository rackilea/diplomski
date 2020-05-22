import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http://stackoverflow.com/questions/20550821/regular-expression-for-getting-number-between-two-words
 */
public class Main {
    public static void main(String[] args) {
        String testString = "I am with weight 600 KG AND HEIGHT 84900 CM";
        Pattern pattern = Pattern.compile("(?<=HEIGHT)\\s*([0-9]+)\\s*(?=CM)");
        Matcher matcher = pattern.matcher(testString);
        while(matcher.find()){
            System.out.println("Height: '" + matcher.group(1) + "'");
        }
    }
}
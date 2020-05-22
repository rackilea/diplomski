import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        String test = "Numéro de réservation   445566553 \tCode";
        Pattern pattern = Pattern.compile("(?<=Num\\u00E9ro\\sde\\sr\\u00E9servation)\\s+(.*?)\\s+(?=Code)");
        Matcher matcher = pattern.matcher(test);
        while(matcher.find()) {
            System.out.println("'"+matcher.group(1)+"'");
        }
    }
}
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Escaping
{
    public static void main(String[] args)
    {
        String inputStr = "Albany, NY + Chicago, IL and IN, NY, OH and WI";
        String patternStr = "(^|\\W|\\G)([a-zA-Z]{2})($|\\W)";

        Pattern myPattern = Pattern.compile(patternStr);
        Matcher myMatcher = myPattern.matcher(inputStr);
        StringBuilder states = new StringBuilder();
        while (myMatcher.find())
        {
            states.append(myMatcher.group(2));
            states.append(" ");
        }

        System.out.println(states);
    }
}
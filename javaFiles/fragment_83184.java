import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        final String regex = "([\\w ]*?)\\s+(?:(\\d+)-(\\d+))?\\s+([\\w ]*)";
        final String[] strings = {"Team A 2-3 Team B", "Team A  Team B"};

        final Pattern pattern = Pattern.compile(regex);

        for (String string : strings) {
            Matcher matcher = pattern.matcher(string);
            if(matcher.find()) {
                System.out.println("Home team: " + matcher.group(1));
                if(matcher.group(2) != null) {
                    System.out.println("Home goal: " + matcher.group(2));
                    System.out.println("Away goal: " + matcher.group(3));
                }
                System.out.println("Away team: " + matcher.group(4));
                System.out.println("\n");
            }
        }
    }
}
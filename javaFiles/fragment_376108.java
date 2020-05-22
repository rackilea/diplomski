import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSquareBrackets{
    public static void main(String[] args) {
        String input = "[text1] [text2] [text3] [text4] [Text5] % & / !";

        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(input);
        ArrayList<String> output = new ArrayList<String>();
        while (matcher.find())
            output.add(matcher.group(1));

        //Print the items out
        System.out.println("Found Text: " + output);
    }
}
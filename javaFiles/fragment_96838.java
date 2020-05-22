import java.util.regex.*;
public class PatternBracket {
    public static void main(String[] args) {
        String input1 = "Request ECUReset for [*11 01]";
        String output1 = getBracketValue(input1);
        System.out.println(input1 + " --> " + output1);

        String input2 = "Request ECUReset for [*11]";
        String output2 = getBracketValue(input2);
        System.out.println(input2 + " --> " + output2);

        String input3 = "Request ECUReset for [*11 01 10]";
        String output3 = getBracketValue(input3);
        System.out.println(input3 + " --> " + output3);
    }
    private static String getBracketValue(String input) {
        Matcher m = Pattern.compile("(?<=\\[\\*)[^\\]]*(?=\\])").matcher(input);
        if (m.find()) {
            return m.group();
        }
        return null;
    }
}
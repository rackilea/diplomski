package stackoverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    private static Pattern outerPattern = Pattern.compile("[^\\(]*(\\([^\\)]*\\))[^\\(]*");
    private static Pattern innerPatter = Pattern.compile("\\(([^\\s\\),]+)|,\\s+([^\\s\\),]+)|([^\\s\\),]+)\\)");

    public static void main(String[] args) {
        List<List<String>> outerResult = new ArrayList<List<String>>();
        String input = "foo (a1, a2, a3, a4 and a5) bar (b1, b2 and b3) more (c1 or c2) ignored (d1, d2) text (e1) the end";
        Matcher outerMatcher = outerPattern.matcher(input);
        while (outerMatcher.find()) {
            outerResult.add(processOuter(outerMatcher));
        }
        System.out.println(outerResult);
    }

    private static List<String> processOuter(Matcher outerMatcher) {
        List<String> innerResult = new ArrayList<String>();
        Matcher innerMatcher = innerPatter.matcher(outerMatcher.group(1));
        while (innerMatcher.find()) {
            innerResult.add(processInner(innerMatcher));
        }
        return innerResult;
    }

    private static String processInner(Matcher innerMatcher) {
        for (int i = 1; i <= innerMatcher.groupCount(); i++) {
            String group = innerMatcher.group(i);
            if (group != null) {
                return group;
            }
        }
        return null;
    }
}
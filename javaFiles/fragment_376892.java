import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("Opening browser 'Google Chrome' to base url 'https://https://stackoverflow.com'.");
        lines.add("Clicking element 'xpath=.//a[contains(normalize-space(@class), \"cc-btn cc-dismiss\")]'.");

        RegexLineAnalyzer regexLineAnalyzer = new RegexLineAnalyzer();
        for (String line : lines) {
            System.out.println(line + " => " + regexLineAnalyzer.extractParameters(line));
        }
    }
}
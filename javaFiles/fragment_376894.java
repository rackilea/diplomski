public class Main {

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        lines.add("Opening browser 'Google Chrome' to base url 'https://https://stackoverflow.com'.");
        lines.add("Clicking element 'xpath=.//a[contains(normalize-space(@class), \"cc-btn cc-dismiss\")]'.");
        lines.add("'Firefox' is used by user 'Tom'.");
        lines.add("Lines like this' could be broken.");
        lines.add("User's first name is 'Jerry'.");
        lines.add("User's last name is 'O'Reilly'");

        SplitLineAnalyzer regexLineAnalyzer = new SplitLineAnalyzer();
        for (String line : lines) {
            System.out.println(line + " => " + regexLineAnalyzer.extractParameters(line));
            System.out.println("");
        }
    }
}
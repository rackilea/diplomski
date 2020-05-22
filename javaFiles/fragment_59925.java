import java.util.regex.*;
public class TEST {
    public static void main(String[] args) {
        String s = "A35, 35A, B503X, 1ABC5 " +
            "AB-10, 10-AB, A10-BA, BA-A10, etc... " +
            "10-10, open-office, etc.";
        Pattern regex = Pattern.compile(
            "# Match special word having one letter and one digit (min).\n" +
            "\\b                       # Match first word having\n" +
            "(?=[-/\\\\A-Za-z]*[0-9])  # at least one number and\n" +
            "(?=[-/\\\\0-9]*[A-Za-z])  # at least one letter.\n" +
            "[A-Za-z0-9]+              # Match first part of word.\n" +
            "(?:                       # Optional extra word parts\n" +
            "  [-/\\\\]                # separated by -, / or //\n" +
            "  [A-Za-z0-9]+            # Match extra word part.\n" +
            ")*                        # Zero or more extra word parts.\n" +
            "\\b                       # Start and end on a word boundary", 
            Pattern.COMMENTS);
        Matcher regexMatcher = regex.matcher(s);
        while (regexMatcher.find()) {
            System.out.print(regexMatcher.group() + ", ");
        } 
    }
}
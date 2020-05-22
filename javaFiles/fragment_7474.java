import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {
    private static String EMAIL_REGEX_NEW_2 = "^[a-zA-Z0-9]{1,}([.-_]{1}[a-zA-Z0-9]{1,})*$";

    public static void main(String[] args) {
        System.out.println("Enter the email name to validate");
        Scanner sc = new Scanner(System.in);

        if (!serverValidationUsingRegexPattern(sc.nextLine(), EMAIL_REGEX_NEW_2)) {
            System.out.println("Sorry, Email name invalid");
        } else {
            System.out.println("Congrats, Email name valid");
        }
    }

    public static boolean serverValidationUsingRegexPattern(String valueToValidate, String regexPattern) {
        Pattern p = Pattern.compile(regexPattern);
        Matcher m = p.matcher(valueToValidate);
        return m.matches();
    }
}
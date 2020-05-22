import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuickTester {

    private static String[] emails = {"abc@gmail.com",
            "randomStringThatMakesNoSense",
            "abc@@@@@", "thisIsRegex@rubbish",
            "test123.com", "goodEmail@hotmail.com",
            "@asdasd@gg.com"};

    public static void main(String[] args) {

        for(String email : emails) {
        System.out.printf("%s is %s.%n",
                email, 
                (isValidEmail(email) ? "Valid" : "Not Valid"));
        }   
    }

    // Assumes that domain name does not contain digits
    private static boolean isValidEmail (String emailStr) {

        // Looking for a string that has at least 1 word character,
        // followed by the '@' sign, followed by at least 1
        // alphabet, followed by the '.' character, and ending with
        // at least 1 alphabet
        String emailPattern = 
                "^\\w{1,}@[a-zA-Z]{1,}\\.[a-zA-Z]{1,}$";

        Matcher m = Pattern.compile(emailPattern).matcher(emailStr);
        return m.matches();
    }
}
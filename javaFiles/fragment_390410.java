import java.util.regex.*;
public class RegexStrings {
    public static void main(String[] args) {
        String input = "Response: Success\n"+
                        "Message: Extension Status\n"+
                        "Exten: 1234\n"+
                        "Context: from-sip\n"+
                        "Hint: DS/5678\n"+
                        "Status: 9";
        String exten = null;
        String status = null;

        Matcher m = Pattern.compile("^Exten: (.+?)$", Pattern.MULTILINE).matcher(input);
        if (m.find()) {
            exten = m.group(1);
        }
        Matcher m2 = Pattern.compile("^Status: (.+?)$", Pattern.MULTILINE).matcher(input);
        if (m2.find()) {
            status = m2.group(1);
        }
        System.out.println("Exten: "+exten);
        System.out.println("Status: "+status);
    }
}
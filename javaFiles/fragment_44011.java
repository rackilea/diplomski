package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSample {
    public static void main(String[] args) {
        String str = "group:192.168.133.205:387/cn=ADMIN,cn=groups,dc=mi,dc=com,dc=usa";
        Pattern pattern = Pattern.compile("^.*/(.*)$");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            String right = matcher.group(1);
            String[] parts = right.split(",");
            for (String part : parts) {
                System.err.println("part: " + part);
            }
        }

    }
}
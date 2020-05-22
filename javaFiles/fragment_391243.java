package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        Pattern p = Pattern.compile(
                "<row><column>(.*)</column></row>",
                Pattern.DOTALL
            );

        Matcher matcher = p.matcher(
                "<row><column>Header\n\n\ntext</column></row>"
            );

        if(matcher.matches()){
            System.out.println(matcher.group(1));
        }
    }

}
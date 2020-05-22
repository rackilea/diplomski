import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression{

    public static void main(String[] args){

        final String regex = "(?m)(?:1[ -])?[(]?(\d{3})[)]?[ -](\d{3})[ -](\d{4})$";
        final String string = "(123)-456-7890\n"
             + "123-456-7890\n"
             + "1-(123)-456-7890\n"
             + "1-123-456-7890\n"
             + "(123) 456-7890\n"
             + "123 456-7890\n"
             + "1-(123) 456-7890\n"
             + "1-123 456-7890\n"
             + "(123) 456 7890\n"
             + "123 456 7890\n"
             + "1 123 456 7890\n"
             + "1 (123) 456 7890";
        final String subst = "1-$1-$2-$3";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        final String result = matcher.replaceAll(subst);

        System.out.println(result);


    }
}
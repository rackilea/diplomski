import  java.util.regex.Pattern;
import  java.util.regex.Matcher;
public class OnlyLettersDigitsCommas  {

   //"": Dummy search string, to reuse matcher
   private static final Matcher lettersCommasMtchr = Pattern.
      compile("^[a-zA-Z0-9,]+$").matcher("");

   public static final boolean isOnlyLettersDigitsCommas(String to_test)  {
      return  lettersCommasMtchr.reset(to_test).matches();
   }

   public static final void main(String[] ignored)  {
      System.out.println(isOnlyLettersDigitsCommas("123,34565,222"));
      System.out.println(isOnlyLettersDigitsCommas("123,123.123."));
   }
}
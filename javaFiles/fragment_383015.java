import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T
{
  public static void main(String[] args)
  {

        final String regex = "^\\s*\n" 
                            + "([a-zA-Z_]\\w+)                                    # function name\n" 
                            + "\\s*\n" 
                            + "(?:\\(|\\G)\n" 
                            + "(\\s*([a-zA-Z_]\\w+)\\s+([a-zA-Z_]\\w+),?)*           #args\n" 
                            + "\\)\n" 
                            + "\\s*$";

        final String string = " _validName__ ( _TypeName _variable)\n" 
                            + " 7invalidName (_TypeName variable)\n" 
                            + "badName_ (_pp8p_7 _s5de)\n" 
                            + " Valid4Name_()\n" 
                            + " validName(7BadType variable)\n" 
                            + " validName_(InvalidParam)\n" 
                            + " validName(Type1 arg1, Type2 arg2)";

        final Pattern pattern = Pattern.compile(regex, Pattern.COMMENTS | Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}
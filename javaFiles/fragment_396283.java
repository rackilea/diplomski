// import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

  public static void main(String[] args){
    // Console console = System.console();  // Not needed

    Pattern pattern = Pattern.compile("<Mytag([^>]*)>");

    String myString = "What is <Mytag a exp 5 exp 3> written as a single power of <i>a</i> <Mytag yx4> and the double power of <b>x+y</b> <Mytag 3xy4>";
    Matcher matcher = pattern.matcher(myString);

    while (matcher.find()) {
      // Rohit Jain observation
      System.out.println(matcher.group(1));
    }

  }
}
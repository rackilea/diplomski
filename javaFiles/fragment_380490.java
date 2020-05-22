import java.util.regex.Matcher;
import java.util.regex.Pattern;

// our main class becomes a file but the main method is still found
public class HelloWorld
{
  public static void main(String[] args)
  {
    String htmlParagraph = "<p>Lets say that this is a sample paragraph with one phone number like 800-965-2321 and another phone number let's say 70923-23124</p>";
    System.out.println("INPUT PARAGRAPH\n-----------\n"+htmlParagraph+"\n-----------\n");
    Pattern p = Pattern.compile("([\\d -]{8,13})");
    Matcher m = p.matcher(htmlParagraph); 
    htmlParagraph = m.replaceAll(" <a href=\"tel:$1\">$1</a> ");
    System.out.println("OUTPUT PARAGRAPH\n-----------\n"+htmlParagraph+"\n-----------\n");
  }
}
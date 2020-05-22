import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class currency {
public static void main(String[] args) throws Exception  {
    URL oracle = new URL("http://www.bnr.ro/nbrfxrates.xml");
    URLConnection yc = oracle.openConnection();
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    BufferedReader in = new BufferedReader(new InputStreamReader(
                            yc.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null) { 
        System.out.println(inputLine);
        pw.println(inputLine);
    }
    in.close();
    pw.close();
    sw.close();

    String data = sw.toString();

    Scanner keyboard = new Scanner(System.in);
    System.out.println("What currency rate do you need?");
    String myString;
    myString = keyboard.nextLine();
    keyboard.close();
    System.out.println("myint: " + myString);

    String ales = myString;

    Pattern pattern = Pattern.compile("<Rate currency=\""+ales+"\">(.+?)</Rate>");
    Matcher matcher = pattern.matcher(data);
    matcher.find();
    System.out.println(matcher.group(1));
    System.out.println(Double.valueOf(matcher.group(1)));
  }
}
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
public static void main(String[] args) 
{
String inputData1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
                        "<!DOCTYPE smil PUBLIC \"-//W3C//DTD SMIL 1.0//EN\" \"SMIL10.dtd\">"
                        + "<head>" 
                        + "</head>" 
                        + "<body>"
                        + "<audio start=\"n=10.815s\" end=\"n=19.914s\"/>"
                        + "<sometag> <audio start=\"n=10.815s\" end=\"n=20.914s\"/> </sometag>"
                        + "</body>"
                        + "</xml>";

    String inputData2 = "some data goes here with or without tags; <audio start=\"n=10.815s\" end=\"n=20.914s\"/>; askjdhfla ";

    Pattern pattern = Pattern.compile("<audio[^>]*start\\s*=\\s*\"n\\s*=\\s*([^\"]*)\"[^>]*end=\"n\\s*=\\s*([^\"]*)\"[^>]*>");
    Matcher matcher = pattern.matcher(inputData1);

    while(matcher.find()){
        System.out.println("start=\"n="+matcher.group(1)+", & end=\"n="+matcher.group(2)+"");
    }

}
}
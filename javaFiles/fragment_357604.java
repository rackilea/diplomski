import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJsoup {
    public static void main(String args[]) throws IOException {
        Document doc = Jsoup.connect("http://www.tutorialspoint.com/ant/ant_deploying_applications.htm").get();

        Elements selects = doc.select("div.middle-col");
        for (Element script : selects) {
            Elements scripts = script.select("script");
            scripts.remove();
        }   
        System.out.println(selects.html());
    }
}
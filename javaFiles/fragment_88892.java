import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Sample {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://howto.unixdev.net").get();
        for (Element file : doc.select("td.right td a")) {
            System.out.println(file.attr("href"));
        }
    }
}
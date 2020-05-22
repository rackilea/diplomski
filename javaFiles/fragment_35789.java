import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class so15933614 {

    public static void main(String[] args) throws IOException {
        String url = "so15933614.html";
        print("Fetching %s...", url);
        Document doc = Jsoup.parse(new File(url), "UTF-8");
        Elements rows = doc.select("tr");
        for (Element row : rows) {
            print("---------");
            Elements data = row.getElementsByTag("td");
            print("First Name:%s", data.get(0).text());
            print("Last Name:%s", data.get(1).text());
            print("Date:%s", data.get(2).text());
            print("City:%s", data.get(3).text());
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}
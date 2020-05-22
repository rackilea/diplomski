import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class WSJParser {

    public static void main(String[] args) {
        String url = "http://online.wsj.com/public/page/news-wall-street-heard.html?dsk=y";
        try {
            Document doc = Jsoup.connect(url).get();
            //doc.select("textarea").remove(); // Removes the entire text area tag
            Document textareaDoc = Jsoup.parseBodyFragment(doc.select("textarea").text());
            System.out.println(textareaDoc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
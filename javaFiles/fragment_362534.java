import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SoGetTitleFromString {

    public static void main(String[] args) throws IOException {

        String html = "<html><head><title>First parse</title></head>"
                  + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        String title = doc.title();
        System.out.println("Title is: " + title);
    }
}
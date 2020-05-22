import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.text.ParseException;


public class SouSoup {
    private static String url = "https://www.avito.ru/voronezh";

    /* Get Data */
    public static void getData() throws IOException, ParseException {
        System.out.println("Fetching file");
        Document doc = Jsoup.connect(url).get();
        Elements res=doc.getElementsByClass("item-description-title-link");
       for (Element elt : res) {
            System.out.println(res.text());
            }
    }

    public static void main(String[] args) throws IOException, ParseException{
        SouSoup.getData();
    }
}
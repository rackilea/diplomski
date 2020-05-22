import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

    public static void main(String[] args) throws Exception {
        String url = "https://stackoverflow.com/questions/2835505";
        Document document = Jsoup.connect(url).get();

        String text = document.select("div").first().text();
        System.out.println(text);

        Elements links = document.select("a");
        for (Element link : links) {
            System.out.println(link.attr("href"));
        }
    }

}
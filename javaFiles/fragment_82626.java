import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSoup {

    public static void main(String[] args) {

        String fichier = "<html>" +
                            "<head></head>" +
                            "<body></body>" +
                            "</html>";
        Document dc = Jsoup.parse(fichier, "utf-8");
        Elements elements = dc.getAllElements();
        elements.forEach( element -> System.out.println(element.nodeName()));
    }
}
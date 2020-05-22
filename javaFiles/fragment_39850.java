import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by hwding on 3/8/17.
 */
public class Bar {
    public static void main(String[] args) {
        String string = "<p>1</p> <p><img src=\"/filename.jpg\" /></p> <p>2</p> <p><img src=\"/filename.jpg\" alt=\"1324\" width=\"600\" height=\"180\" /></p> <p>3</p> <p><img style=\"border-width: 1px;\" src=/filename.jpg\" alt=\"\" width=\"1000\" height=\"300\" /></p> <p>4</p> <p><img style=\"border-width: 1px; max-width:100%\" src=/filename.jpg\" alt=\"\" width=\"1000\" height=\"300\" /></p>";

        Document document = Jsoup.parse(string);
        Elements elements = document.select("img");

        elements.forEach(e -> {
            if(!e.hasAttr("style"))
                e.attr("style", "max-width:100%");
            System.out.println(e.toString());
        });
    }
}
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class SoGetTitlesFromListOfUrls {

    public static void main(String[] args) throws IOException {

        String inUrls = "http://www.miamitodaynews.com/news/050113/crossword.shtml ()\n"
                + "http://www.miamitodaynews.com/news/081218/cal-highlights.shtml/feed/ ()\n"
                + "http://www.miashoes.com/mia-limited-edition/flats.html?refineclr=2125%2C2136 ()\n"
                + "http://www.mica.edu/News/Workshop_on_111809_Archive_and_Inventory_Your_Image_Collections.html ()\n"
                + "http://www.michaelgeist.ca/2011/10/daily-digital-lock-15/ ()\n"
                + "http://www.michaelkors.com/bags/_/N-283g?cmCat=cat000000cat144cat44301cat44302&index=9&isEditorial=false ()\n"
                + "http://www.michaelkors.com/watches/_/N-28c2?cmCat=cat000000cat145cat35701cat30001&index=39&isEditorial=false ()\n"
                + "http://www.michaelkors.com/watches/_/N-28c2?cmCat=cat000000cat145cat7502&index=92&isEditorial=false ()\n"
                + "http://www.michaelmillerfabrics.com/catalog/seo_sitemap/product/?p=2 ()\n"
                + "http://www.michaels.com/10104250.html ()\n";

        Scanner UrlScanner = new Scanner(inUrls);
        while (UrlScanner.hasNextLine()) {
            String url = UrlScanner.nextLine().split(" ")[0]; // Get the first token from the line, space delimited
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            System.out.println("Title is: " + title);   
        }
    }
}
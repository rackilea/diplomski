import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    public static void main(String[] args) {
        try {
            String url = "http://www.larousse.fr/dictionnaires/francais-anglais/écrémer/27576?q=écrémé";

            Document doc = Jsoup.connect(url)
                                .userAgent("Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)")
                                .get();

            System.out.println(doc.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
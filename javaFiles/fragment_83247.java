import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSoupAnswer {

    public static void main(String[] args) {

        String p = "<p><img class=\"aligncenter size-full wp-image-610\" src=\"https://muslimmemo.com/wp-content/uploads/2015/08/al-rundi-fall-seville-poem-arabic.png\" alt=\"al-rundi-fall-seville-poem-arabic\" width=\"591\" height=\"606\" /></p>";
        Document doc = Jsoup.parse(p);
        Elements img = doc.select("p").select("img");
        if (img.size() > 0)
            System.out.println(img);
    }

}
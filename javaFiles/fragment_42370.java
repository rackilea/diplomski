import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Foo003 {
   private static final String TEST_URL_1 = "http://xbox360.ign.com/" +
        "articles/117/1171345p1.html";

   public static void main(String[] args) {
      Document jsDoc = null;

      try {
         jsDoc = Jsoup.connect(TEST_URL_1).get();
         // System.out.println(jsDoc);

         Elements img = jsDoc.select("div.imageInlineCenter img[src]");
         String imgSrc = img.attr("src");
         System.out.println(imgSrc);

      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
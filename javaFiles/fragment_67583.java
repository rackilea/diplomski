import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HaloStuff {
   private static final String TEST_URL_1 = "http://www.upcominggames.com/" +
        "2113/Halo+Combat+Evolved+Anniversary/";
   private static final String DIV_TAG = "div";
   private static final String ID_ATTR = "id";
   private static final String GAME_DESC = "game-desc";

   public static void main(String[] args) {
      Document jsDoc = null;

      List<String> textList = new ArrayList<String>();

      try {
         jsDoc = Jsoup.connect(TEST_URL_1).get();

         Elements textEles = jsDoc.select("div[id=game-desc]");
         for (Element ele : textEles) {
            System.out.println(ele.text());
         }

      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
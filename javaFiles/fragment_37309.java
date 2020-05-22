import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
    public static void main(String argv[]){
        String html = "<table>"+
                    "  <td style=\"padding-left: 5px; padding-right: 5px; padding-top: 1px; padding-bottom: 1px; border: none;\">" +
                    "    <strong>test:</strong> 62" +
                    "  </td>" +
                    "  <td style=\"padding-left: 5px; padding-right: 5px; padding-top: 1px; padding-bottom: 1px; border: none;\">" +
                    "    <a style=\"color: inherit;\" href=\"redacted\">" +
                    "      <strong>test:</strong> 51" +
                    "    </a>" +
                    "  </td>" +
                    "  <td style=\"padding-left: 5px; padding-right: 5px; padding-top: 1px; padding-bottom: 1px; border: none;\">" +
                    "    <a style=\"color: inherit;\" href=\"redacted\">" +
                    "      <strong>test:</strong> 11" +
                    "    </a>" +
                    "  </td>";
        Document doc = Jsoup.parse(html);
        Elements tds = doc.select("td");
        for(Element e : tds){
            if (!e.ownText().isEmpty()){
                System.out.println(e.ownText());
            }
            else{
                System.out.println(e.child(0).ownText());
            }
        }           
    } 
}
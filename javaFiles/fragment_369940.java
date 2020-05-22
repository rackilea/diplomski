import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class JSoupTest 
{
    public static void main(String[] args) 
    {
         String html =   "<li class='pro pic notSold' status='0' >";
         html+=      "<ul><li></li><ul>";
         html+=   "<li class='pro pic soldOut' status='-1' >";
         html+=      "<ul><li></li><ul>";

         Document doc = Jsoup.parse(html);
         Elements elems = doc.select("[class^=pro pic]");

        System.out.println(elems.size());
    }
}
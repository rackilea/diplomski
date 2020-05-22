import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CsDotQauDotEduPk {

public static void main(String[] args) throws Exception {

    Document doc = Jsoup.connect("http://cs.qau.edu.pk/faculty.php/").get();

    Elements ele = doc.select("div.container td");
    for (Element e : ele) {

        Elements el = e.select("strong").eq(0);
        Elements e2 = e.select("td p").eq(1);

        final String name = el.text();
        final String details = e2.text();

        System.out.println(name+" >> "+ details);
    }}}
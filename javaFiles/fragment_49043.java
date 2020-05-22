import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class StackOverflow58484337 {

    public static void main(String[] args) {
        String html = "<if><except><if><except><if /></except></if></except></if>";
        Document doc = Jsoup.parse(html, "", Parser.xmlParser());
        // select every "if" element
        Elements ifs = doc.select("if");
        System.out.println("--- before:");
        System.out.println(doc);
        // check every "if" element if any of its parents is "except" element
        for (Element singleIf : ifs) {
            if (isOutsideExcept(singleIf)) {
                // wrap it in "print" element
                singleIf.children().wrap("<print>");
            }
        }
        System.out.println("--- after:");
        System.out.println(doc);
    }

    private static boolean isOutsideExcept(Element singleIf) {
        Element parent = singleIf.parent();
        // check parent, and parent of his parent, and parent of his parent ...
        while (parent != null) {
            if (parent.tagName().equals("except")) {
                return false;
            }
            parent = parent.parent();
        }
        return true;
    }

}
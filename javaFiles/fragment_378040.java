import java.util.List;
import org.jsoup.*;
import org.jsoup.nodes.*;

public class Example {
    public static void main(String[] args) throws Exception {
        String htmlExample = "<body>" +
            "<div1> one" +
              "<h2> two </h2>" +
              "<div2> three" +
                "<div3> four </div3>" +
              "</div2>" +
              "<p> five </p> " +
            "six" +
            "</div1>" +
            "</body>";
        Document htmlDocument = Jsoup.parse(htmlExample);
        visitNodes(htmlDocument.body().childNodes());
    }

    static void visitNodes(List<Node> nodes) {
        visitNodes(nodes, null);
    }
    static void visitNodes(List<Node> nodes, String prefix) {
        for (Node child : nodes) {
            if (child instanceof Element) {
                Element e = (Element)child;
                visitNodes(e.childNodes(), e.tagName() + ":");
            } else if (child instanceof TextNode) {
                if (prefix != null) {
                    System.out.print(prefix);
                }
                System.out.println(((TextNode)child).text());
            }
        }
    }
}
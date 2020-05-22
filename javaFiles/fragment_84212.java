import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.util.List;

public class Program {

public static void main(String...args) throws Exception {
    String searchFor = "online and";

    Document doc = Jsoup.connect("http://en.wikipedia.org/wiki/2012_in_American_television").get();
    Element element = doc.getElementsContainingOwnText(searchFor).first();

    Node nodeWithText = getFirstNodeContainingText(element.childNodes(), searchFor);
    Element closestLink = getClosestLink(nodeWithText);

    System.out.println("Link closest to '" + searchFor + "': " + closestLink.attr("abs:href"));
}

private static Element getClosestLink(Node node) {
    Element linkElem = null;
    if (node instanceof Element) {
        Element element = (Element) node;
        linkElem = element.getElementsByTag("a").first();
    }
    if (linkElem != null) {
        return linkElem;
    }

    // This node wasn't a link. try next one
    linkElem = getClosestLink(node.nextSibling());
    if (linkElem != null) {
        return linkElem;
    }

    // Wasn't next link. try previous
    linkElem = getClosestLink(node.previousSibling());
    if (linkElem != null) {
        return linkElem;
    }

    return null;
}

private static Node getFirstNodeContainingText(List<Node> nodes, String text) {
    for (Node node : nodes) {
        if (node instanceof TextNode) {
            String nodeText = ((TextNode) node).getWholeText();
            if (nodeText.contains(text)) {
                return node;
            }
        }
    }
    return null;
}
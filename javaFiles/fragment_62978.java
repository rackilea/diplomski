import javax.xml.xpath.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.*;

public class XPathTest {
    static class Entry {
        final String title, id, origin, type;
        Entry(String title, String id, String origin, String type) {
            this.title = title;
            this.id = id;
            this.origin = origin;
            this.type = type;
        }
        @Override public String toString() {
            return String.format("%s:%s(%s)[%s]", id, title, origin, type);
        }
    }

    final static XPath xpath = XPathFactory.newInstance().newXPath();
    static String evalString(Node context, String path) throws XPathExpressionException {
        return (String) xpath.evaluate(path, context, XPathConstants.STRING);
    }

    public static void main(String[] args) throws Exception {
        File file = new File("feed.xml");
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        NodeList entriesNodeList = (NodeList) xpath.evaluate("//entry", document, XPathConstants.NODESET);

        List<Entry> entries = new ArrayList<Entry>();
        for (int i = 0; i < entriesNodeList.getLength(); i++) {
            Node entryNode = entriesNodeList.item(i);
            entries.add(new Entry(
                evalString(entryNode, "title"),
                evalString(entryNode, "id"),
                evalString(entryNode, "tempi/conento/@madeIn"),
                evalString(entryNode, "tempi/@type")
            ));
        }
        for (Entry entry : entries) {
            System.out.println(entry);
        }
    }
}
import java.util.*;
import java.io.ByteArrayInputStream;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;

public class XmlParse {
    public static void main(String[] args) throws Exception {

        String xml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<mynode xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.example.com\" xsi:schemaLocation=\"http://www.example.com example.xsd\">" +
            "<name>TargetName</name>" +
            "</mynode>";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));

        final String nonameNamespace = doc.getFirstChild().getNamespaceURI();

        NamespaceContext ctx = new NamespaceContext() {
            public String getNamespaceURI(String prefix) {
                String uri = null;
                if (prefix.equals("n")) {
                    uri = nonameNamespace;
                }
                return uri;
            }

            @Override
            public Iterator getPrefixes(String val) {
                throw new IllegalAccessError("Not implemented!");
            }

            @Override
            public String getPrefix(String uri) {
                throw new IllegalAccessError("Not implemented!");
            }
        };

        XPath xPath = XPathFactory.newInstance().newXPath();
        xPath.setNamespaceContext(ctx);


        Node node = null;
        try {
            node = (Node) xPath.evaluate("/n:mynode/n:name", doc, XPathConstants.NODE);
            System.out.println(node.getNodeName());
            System.out.println(node.getFirstChild().getNodeValue());
        } catch (Exception e) {

        }
    }
}
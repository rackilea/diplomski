import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class TestXML {

    private static Document loadTestDocument(String url) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(new URL(url).openStream());
    }

    public static void main(String[] args) throws Exception {
        Document doc = loadTestDocument("http://www.enetpulse.com/wp-content/uploads/sample_xml_feed_enetpulse_soccer.xml");
        System.out.println(doc);
        doc = loadTestDocument("http://localhost/array.xml");
        System.out.println(doc);
    }
}
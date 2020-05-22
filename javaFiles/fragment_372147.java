import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLParsingTest {

    private static final String XML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
            + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
            +   "<soapenv:Body><ns0:Get_People_Operation xmlns:ns0=\"urn:PeopleInterface\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
            + "<ns0:Full_Name>asdf - Full Name</ns0:Full_Name>"
            + "</ns0:Get_People_Operation>"
            + "</soapenv:Body>"
            + "</soapenv:Envelope>";

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        Document doc = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new StringReader(XML)));
        Element elt = doc.getDocumentElement();
        System.out.println(getNode(elt, "Full_Name"));
    }

    private static String getNode(Element responseElement, String nodeValue) {

        NodeList nodeList = responseElement.getElementsByTagNameNS("urn:PeopleInterface",nodeValue);
        Node x = nodeList.item(0);

        // Test list output
        System.out.println("");
        System.out.println(nodeValue + " Value: " + x.toString());
        System.out.println("");

        return x.getTextContent();
    }

}
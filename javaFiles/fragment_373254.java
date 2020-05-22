import java.io.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;

public class TestValidation {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList)xpath.evaluate("/*/*", new InputSource("XmlWithEmbeddedXsd.xml"), XPathConstants.NODESET);
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Validator validator = factory.newSchema(new DOMSource(nodes.item(0))).newValidator();
        try {
            validator.validate(new DOMSource(nodes.item(1)));
            System.out.println("XML is valid.");
        }
        catch (SAXException ex) {
            System.out.println("XML is not valid because " + ex.getMessage());
        }
    }
}
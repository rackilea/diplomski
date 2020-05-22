import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathTest {

    public static void main(String[] args) {

        InputStream is = null;

        try {
            is = new FileInputStream("Soap.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(false);
            Document doc = dbf.newDocumentBuilder().parse(is);

            XPathFactory xf = XPathFactory.newInstance();
            XPath xPath = xf.newXPath();

            // Find direction ANY where within the document...

            XPathExpression xExp = xPath.compile("//Direction");
            NodeList nl = (NodeList) xExp.evaluate(doc, XPathConstants.NODESET);
            for (int index = 0; index < nl.getLength(); index++) {
                Node node = nl.item(index);
                System.out.println(node.getTextContent());
            }

            // Find the direction node's any where in the document
            // where it's a child of Route, which has a child
            // node called RouteNo with the text value of 'int'...
            xExp = xPath.compile("//Route[RouteNo = 'int']/Direction");
            nl = (NodeList) xExp.evaluate(doc, XPathConstants.NODESET);
            for (int index = 0; index < nl.getLength(); index++) {
                Node node = nl.item(index);
                System.out.println(node.getTextContent());
            }

        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException exp) {
            exp.printStackTrace();
        }
    }
}
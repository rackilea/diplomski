import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Demo {

    public static void main(String[] args) {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            File xml = new File("input.xml");
            Document dDoc = builder.parse(xml);

            NodeList nl;

            // OPTION #1
            XPath xPath = XPathFactory.newInstance().newXPath();
            nl = (NodeList) xPath.evaluate("root/device/modelname", dDoc, XPathConstants.NODESET);
            printResults(nl);
            nl = (NodeList) xPath.evaluate("/root/device/modelname", dDoc, XPathConstants.NODESET);
            printResults(nl);

            // OPTION #2
            XPathExpression xPathExpression = xPath.compile("/root/device/modelname");
            nl = (NodeList) xPathExpression.evaluate(dDoc, XPathConstants.NODESET);
            printResults(nl);
            nl = (NodeList) xPathExpression.evaluate(dDoc, XPathConstants.NODESET);
            printResults(nl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printResults(NodeList nl) {
        for(int x=0; x<nl.getLength(); x++) {
            System.out.println("the value is: " + nl.item(x).getTextContent());
        }
    }

}
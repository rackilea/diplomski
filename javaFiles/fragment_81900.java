import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SimpleClass2 {

    public static void main(String[] args) throws InterruptedException, XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        String str = "<main-project name=\"\" version=\"1.0.2\">\n" +
                "<data name=\"data\">\n" +
                "<tag>\n" +
                "<link-to  object=\"processor\"/>\n" +
                "</tag>\n" +
                "</data>\n" +
                "<output name=\"output\">\n" +
                "<tag>\n" +
                "<link-to  object=\"processor\"/>\n" +
                "</tag>\n" +
                "</output>\n" +
                "<processor name =\"processor\">\n" +
                "<tag>\n" +
                "<link-to  object=\"data\"/>\n" +
                "</tag>\n" +
                "</processor>\n" +
                "</main-project>";
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document xmlDoc = builder.parse(new ByteArrayInputStream(str.getBytes()));
        XPath xPath =  XPathFactory.newInstance().newXPath();

        NodeList linkageNodesEpf = (NodeList) xPath.compile("//link-to[@object = 'processor']").evaluate(xmlDoc, XPathConstants.NODESET);
        for (int i = 0; i < linkageNodesEpf.getLength(); i++) {
            System.out.println(linkageNodesEpf.item(i));
        }
    }

}
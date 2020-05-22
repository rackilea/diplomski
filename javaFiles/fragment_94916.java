import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class XPathExtract {

  public static void main(String[] args) throws SAXException, IOException,
      ParserConfigurationException, XPathExpressionException {
    String xml = "...";

    // Parse the XML as DOM
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        .parse(new InputSource(new StringReader(xml)));

    // Create a XPath instance
    XPath xpath = XPathFactory.newInstance().newXPath();

    // Evaluate the XPath. The result is a NodeList
    NodeList nodes = (NodeList) xpath.evaluate(
      "PromoteData/Table[@Id='auditSet']/Table[@Id='auditSetMapping']/Table[@Id='appExpr']", 
        doc, XPathConstants.NODESET);

    // Iterate over the nodes
    for (int i = 0; i < nodes.getLength(); i++) {
      // node.item(i) is a Node. If you are sure, it is always an Element you can do a cast
      Element el = (Element) nodes.item(i);
      // Process the element
      System.out.println(el.getAttribute("Id"));
    }
  }
}
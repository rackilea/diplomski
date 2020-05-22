package xml;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class XMLComment {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        // Create root node
        Node rootNode = doc.createElement("DataConfiguration");
        doc.appendChild(rootNode);

        // Create syntax identification comment
        Comment syntaxIdentification = doc.createComment("SyntaxIdentification: 1.0");
        doc.insertBefore(syntaxIdentification, rootNode);

        // Create modificationNumber
        Node modificationNumber = doc.createElement("modificationNumber");
        Text mnText = doc.createTextNode("123456");
        modificationNumber.appendChild(mnText);

        // Create modificationTime
        Element modificationTime = doc.createElement("modificationTime");
        Text mtText = doc.createTextNode("2019-07-25 07:42:28.804 +0200");
        modificationTime.appendChild(mtText);

        rootNode.appendChild(modificationNumber);
        rootNode.appendChild(modificationTime);
        printXML(doc);

    }

    private static void printXML(Document doc) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        // initialize StreamResult with File object to save to file
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);
        String xmlString = result.getWriter().toString();
        System.out.println(xmlString);
    }
}
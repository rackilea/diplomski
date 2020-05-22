import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLWrapper {

    public static void main(final String[] args) throws Exception {
        final File inputFile = new File(
                "/Users/richard/Documents/workspace/so/input.xml");
        final File outputFile = new File(
                "/Users/richard/Documents/workspace/so/output.xml");

        // Read in the file using the DOM parser
        final DocumentBuilderFactory factory = DocumentBuilderFactory
                .newInstance();
        final Document document = factory.newDocumentBuilder().parse(inputFile);

        // Find the TBCOMPROBANTE node
        final NodeList childNodes = document
                .getElementsByTagName("TBCOMPROBANTE");
        final Node chosenNode = childNodes.item(0);

        // Create a new document and add the extra node
        final Document newDocument = factory.newDocumentBuilder().newDocument();
        final Element createElement = newDocument.createElement("Arba");
        newDocument.appendChild(createElement);

        // Import the node we found and append it to the new element
        final Node importNode = newDocument.importNode(chosenNode, true);
        createElement.appendChild(importNode);
        newDocument.normalize();

        // Use a Transformer to write the xml to outputFile
        final TransformerFactory tFactory = TransformerFactory.newInstance();
        final Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        final DOMSource source = new DOMSource(newDocument);
        final StreamResult result = new StreamResult(outputFile);
        transformer.transform(source, result);

    }
}
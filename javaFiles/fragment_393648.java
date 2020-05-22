import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class FormatXml {

    public static void main(String[] args) throws ParserConfigurationException,
            FileNotFoundException, SAXException, IOException,
            TransformerException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = docBuilderFactory
                .newDocumentBuilder();
        Document node = documentBuilder.parse(new FileInputStream("data.xml"));
        System.out.println(format(node, 4));
    }

    public static String format(Node node, int indent)
            throws TransformerException {
        cleanEmptyTextNodes(node);
        StreamResult result = new StreamResult(new StringWriter());
        getTransformer(indent).transform(new DOMSource(node), result);
        return result.getWriter().toString();
    }

    private static Transformer getTransformer(int indent) {
        Transformer transformer;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create the Transformer", e);
        }
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount",
                Integer.toString(indent));
        return transformer;
    }

    /**
     * Removes text nodes that only contains whitespace. The conditions for
     * removing text nodes, besides only containing whitespace, are: If the
     * parent node has at least one child of any of the following types, all
     * whitespace-only text-node children will be removed: - ELEMENT child -
     * CDATA child - COMMENT child
     * 
     * The purpose of this is to make the format() method (that use a
     * Transformer for formatting) more consistent regarding indenting and line
     * breaks.
     */
    private static void cleanEmptyTextNodes(Node parentNode) {
        boolean removeEmptyTextNodes = false;
        Node childNode = parentNode.getFirstChild();
        while (childNode != null) {
            removeEmptyTextNodes |= checkNodeTypes(childNode);
            childNode = childNode.getNextSibling();
        }

        if (removeEmptyTextNodes) {
            removeEmptyTextNodes(parentNode);
        }
    }

    private static void removeEmptyTextNodes(Node parentNode) {
        Node childNode = parentNode.getFirstChild();
        while (childNode != null) {
            // grab the "nextSibling" before the child node is removed
            Node nextChild = childNode.getNextSibling();

            short nodeType = childNode.getNodeType();
            if (nodeType == Node.TEXT_NODE) {
                boolean containsOnlyWhitespace = childNode.getNodeValue()
                        .trim().isEmpty();
                if (containsOnlyWhitespace) {
                    parentNode.removeChild(childNode);
                }
            }
            childNode = nextChild;
        }
    }

    private static boolean checkNodeTypes(Node childNode) {
        short nodeType = childNode.getNodeType();

        if (nodeType == Node.ELEMENT_NODE) {
            cleanEmptyTextNodes(childNode); // recurse into subtree
        }

        if (nodeType == Node.ELEMENT_NODE
                || nodeType == Node.CDATA_SECTION_NODE
                || nodeType == Node.COMMENT_NODE) {
            return true;
        } else {
            return false;
        }
    }

}
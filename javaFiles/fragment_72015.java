import java.io.File;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ConvertToXML {

    public static void main(String[] args) {
        TreeModel model = new DefaultTreeModel(...);

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().newDocument();
            Element rootElement = doc.createElement("treeModel");

            doc.appendChild(rootElement);

            // Get tree root...
            TreeNode root = (TreeNode) model.getRoot();

            parseTreeNode(root, rootElement);

            // Save the document to disk...

            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty(OutputKeys.METHOD, "xml");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource domSource = new DOMSource(doc);
            StreamResult sr = new StreamResult(new File("TreeModel.xml"));
            tf.transform(domSource, sr);

        } catch (ParserConfigurationException | TransformerException ex) {
            ex.printStackTrace();
        }
    }

    private static void parseTreeNode(TreeNode treeNode, Node doc) {

        Element parentElement = doc.getOwnerDocument().createElement("node");
        doc.appendChild(parentElement);

        // Apply properties to root element...
        Attr attrName = doc.getOwnerDocument().createAttribute("name");
        attrName.setNodeValue(...);
        parentElement.getAttributes().setNamedItem(attrName);

        Enumeration kiddies = treeNode.children();
        while (kiddies.hasMoreElements()) {
            TreeNode child = (TreeNode) kiddies.nextElement();
            parseTreeNode(child, parentElement);
        }

    }

}
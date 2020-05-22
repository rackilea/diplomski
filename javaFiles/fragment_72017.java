import java.io.File;
import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TreeExample {

    public static void main(String[] args) {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("The Java Series");
        createNodes(top);
        TreeModel model = new DefaultTreeModel(top);

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().newDocument();

            // Get tree root...
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

            parseTreeNode(root, doc);

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

    protected static void parseTreeNode(DefaultMutableTreeNode treeNode, Document doc) {

            String value = treeNode.getUserObject().toString();
            Element rootElement = doc.createElement("Library");
            doc.appendChild(rootElement);

            Enumeration kiddies = treeNode.children();
            while (kiddies.hasMoreElements()) {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) kiddies.nextElement();
                parseTreeNode(child, rootElement);
            }

    }

    protected static void parseTreeNode(DefaultMutableTreeNode treeNode, Element doc) {

        Object value = treeNode.getUserObject();

        Element parentElement = null;
        if (value instanceof BookInfo) {
            parentElement = doc.getOwnerDocument().createElement("book");

            BookInfo book = (BookInfo) value;
            // Apply properties to root element...
            Attr attrName = doc.getOwnerDocument().createAttribute("name");
            attrName.setNodeValue(book.getBookName());
            parentElement.getAttributes().setNamedItem(attrName);

            Attr attrURL = doc.getOwnerDocument().createAttribute("url");
            attrURL.setNodeValue(book.getBookURL());
            parentElement.getAttributes().setNamedItem(attrURL);
        } else if (value instanceof BookCatagory) {
            parentElement = doc.getOwnerDocument().createElement("catagory");

            BookCatagory book = (BookCatagory) value;
            // Apply properties to root element...
            Attr attrName = doc.getOwnerDocument().createAttribute("name");
            attrName.setNodeValue(book.getCatagory());
            parentElement.getAttributes().setNamedItem(attrName);
        }

        doc.appendChild(parentElement);

        Enumeration kiddies = treeNode.children();
        while (kiddies.hasMoreElements()) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) kiddies.nextElement();
            parseTreeNode(child, parentElement);
        }
    }

    protected static void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode(new BookCatagory("Books for Java Programmers"));
        top.add(category);

        //original Tutorial
        book = new DefaultMutableTreeNode(new BookInfo("The Java Tutorial: A Short Course on the Basics",
                "tutorial.html"));
        category.add(book);

        //Tutorial Continued
        book = new DefaultMutableTreeNode(new BookInfo("The Java Tutorial Continued: The Rest of the JDK",
                "tutorialcont.html"));
        category.add(book);

        //JFC Swing Tutorial
        book = new DefaultMutableTreeNode(new BookInfo("The JFC Swing Tutorial: A Guide to Constructing GUIs",
                "swingtutorial.html"));
        category.add(book);

        //Bloch
        book = new DefaultMutableTreeNode(new BookInfo("Effective Java Programming Language Guide",
                "bloch.html"));
        category.add(book);

        //Arnold/Gosling
        book = new DefaultMutableTreeNode(new BookInfo("The Java Programming Language", "arnold.html"));
        category.add(book);

        //Chan
        book = new DefaultMutableTreeNode(new BookInfo("The Java Developers Almanac",
                "chan.html"));
        category.add(book);

        category = new DefaultMutableTreeNode(new BookCatagory("Books for Java Implementers"));
        top.add(category);

        //VM
        book = new DefaultMutableTreeNode(new BookInfo("The Java Virtual Machine Specification",
                "vm.html"));
        category.add(book);

        //Language Spec
        book = new DefaultMutableTreeNode(new BookInfo("The Java Language Specification",
                "jls.html"));
        category.add(book);
    }

    public static class BookCatagory {

        private String catagory;

        public BookCatagory(String cat) {
            this.catagory = cat;
        }

        public String getCatagory() {
            return catagory;
        }

    }

    private static class BookInfo {

        private String bookName;
        private String bookURL;

        public BookInfo(String book, String filename) {
            bookName = book;
            bookURL = filename;
        }

        public String getBookName() {
            return bookName;
        }

        public String getBookURL() {
            return bookURL;
        }

        public String toString() {
            return bookName;
        }
    }
}
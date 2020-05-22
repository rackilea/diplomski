import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

public class XMLTreeView {
    private SAXTreeBuilder saxTree = null;
    private static String file = "";

    public static void main(String args[]) {
        file = "etc\\q29921994\\example2.xml";
        JFrame frame = new JFrame("XMLTreeView: [ " + file.substring(file.lastIndexOf("\\") + 1) + " ]");
        frame.setSize(400, 400);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
        new XMLTreeView(frame);
    }

    public XMLTreeView(JFrame frame) {
        frame.getContentPane().setLayout(new BorderLayout());
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(file);
        //    DefaultMutableTreeNode top = new DefaultMutableTreeNode("XML Document");
        saxTree = new SAXTreeBuilder(top);

        try {
            SAXParser saxParser = new SAXParser();
            saxParser.setContentHandler(saxTree);
            saxParser.parse(new InputSource(new FileInputStream(file)));
        } catch (Exception ex) {
            top.add(new DefaultMutableTreeNode(ex.getMessage()));
        }
        JTree tree = new JTree(saxTree.getTree());
        JScrollPane scrollPane = new JScrollPane(tree);

        frame.getContentPane().add("Center", scrollPane);
        frame.setVisible(true);
    }
}


class SAXTreeBuilder extends DefaultHandler {
    private DefaultMutableTreeNode currentNode = null;
    private DefaultMutableTreeNode previousNode = null;
    private DefaultMutableTreeNode rootNode = null;

    public SAXTreeBuilder(DefaultMutableTreeNode root) {
        rootNode = root;
    }

    public void startDocument() {
        currentNode = rootNode;
    }

    public void endDocument() {
    }

    public void characters(char[] data, int start, int end) {
        String str = new String(data, start, end);
        if (!str.equals("") && Character.isLetter(str.charAt(0)))
            currentNode.add(new DefaultMutableTreeNode(str));
    }

    public void startElement(String uri, String qName, String lName, Attributes atts) {
        previousNode = currentNode;
        // currentNode = new DefaultMutableTreeNode(lName);
        // Use the result of the getNodeText method to construct the tree node.
        currentNode = new DefaultMutableTreeNode(getNodeText(lName, atts));
        // Add attributes as child nodes //
        attachAttributeList(currentNode, atts);
        previousNode.add(currentNode);
    }

    public void endElement(String uri, String qName, String lName) {
        // I think the if below can be removed:
        //if (currentNode.getUserObject().equals(lName))
            currentNode = (DefaultMutableTreeNode) currentNode.getParent();
    }

    private String getNodeText(final String lName, final Attributes atts) {
        final String postfix;

        if ("NE".equals(lName) && atts.getValue("NEType") != null)
            postfix = " NEType=" + atts.getValue("NEType");
        else if ("EQHO".equals(lName) && atts.getValue("equipmentHolderType") != null)
            postfix = " equipmentHolderType=" + atts.getValue("equipmentHolderType");
        else if ("UNIT".equals(lName) && atts.getValue("unitTypeActual") != null)
            postfix = " equipmentHolderType=" + atts.getValue("unitTypeActual");
        else if ("FUUT".equals(lName) && atts.getValue("functionalUnitType") != null)
            postfix = " equipmentHolderType=" + atts.getValue("functionalUnitType");
        else
            postfix = "";

        return lName + postfix;
    }

    public DefaultMutableTreeNode getTree() {
        return rootNode;
    }

    private void attachAttributeList(DefaultMutableTreeNode node, Attributes atts) {
        for (int i = 0; i < atts.getLength(); i++) {
            String name = atts.getLocalName(i);
            String value = atts.getValue(name);
            node.add(new DefaultMutableTreeNode(name + " = " + value));
        }
    }
}
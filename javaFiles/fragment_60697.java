import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.tree.*;

public class TextPaneCssSpill extends JFrame {

    private JTextPane textPane;
    private JTree tree;
    private JSplitPane splitPane;
    private StyleSheet style;

    public TextPaneCssSpill() {
        MyHTMLEditorKit hed = new MyHTMLEditorKit();
        StyleSheet defaultStyle = hed.getDefaultStyleSheet();
        style = new StyleSheet();
        style.addStyleSheet(defaultStyle);
        style.addRule("body {font-family:\"Monospaced\"; font-size:9px;}");
        style.addRule("i {color:#bababa; font-size:9px;}"); // gray italic
        hed.setStyleSheet(style);

        textPane = new JTextPane();        
        textPane.setEditorKit(hed);
        textPane.setDocument(hed.createDefaultDocument());
        appendHtmlToTextPane("<i>our gray italic text</i>", textPane);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new MyNode("name", "argument"), true);
        root.add(new DefaultMutableTreeNode(new MyNode("name", "argument"), false));
        root.add(new DefaultMutableTreeNode(new MyNode("name", "argument"), false));
        root.add(new DefaultMutableTreeNode(new MyNode("name", "argument"), false));
        root.add(new DefaultMutableTreeNode(new MyNode("name", "argument"), false));

        tree = new JTree(root);
        tree.setCellRenderer(new MyNodeTreeRenderer());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textPane, tree);
        add(splitPane);

        pack();
        setLocationRelativeTo(null);
    }

    private void appendHtmlToTextPane(String str, JTextPane pane) {
        Document doc = pane.getDocument();
        if (doc != null) {
            if (doc instanceof HTMLDocument) {
                HTMLDocument htmlDoc = (HTMLDocument) doc;
                Element html = htmlDoc.getDefaultRootElement();
                if (HTML.Tag.HTML.toString().equalsIgnoreCase(html.getName())) {
                    Element body = null;
                    for (int i = 0; i < html.getElementCount(); i++) {
                        Element element = html.getElement(i);
                        if (element.getAttributes().getAttribute(StyleConstants.NameAttribute) == HTML.Tag.BODY) {
                            body = element;
                            break;
                        }
                    }
                    if (HTML.Tag.BODY.toString().equalsIgnoreCase(body.getName())) {
                        try {                            
                            htmlDoc.insertBeforeEnd(body, str);
                            Element lastLine = body.getElement(body.getElementCount() - 1);
                            int end = lastLine.getStartOffset();
                            textPane.setCaretPosition(end);

                        } catch (BadLocationException e) {
                        } catch (IOException ex) {
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextPaneCssSpill().setVisible(true);
            }
        });
    }

    private static class MyNode {
        private final String name;
        private final String argument;

        public MyNode(String name, String argument) {
            this.name = name;
            this.argument = argument;
        }

        @Override
        public String toString() {
            return name + " " + argument;
        }        
    }

    private static class MyNodeTreeRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            if (value instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
                if (node.getUserObject() instanceof MyNode) {
                    MyNode mynode = (MyNode) node.getUserObject();
                    setText("<html>" + mynode.name + "&nbsp;<i>" + mynode.argument);
                }
            }
            return this;
        }

    }

    /**
     * Avoid setting the stylesheet for all HTMLEditorKit instances.
     */
    private static class MyHTMLEditorKit extends HTMLEditorKit {

        private StyleSheet myStyle;

        @Override
        public StyleSheet getStyleSheet() {
            return myStyle == null ? super.getStyleSheet() : myStyle;
        }

        @Override
        public void setStyleSheet(StyleSheet s) {
            this.myStyle = s;
        }

        public StyleSheet getDefaultStyleSheet() {
            return super.getStyleSheet();
        }

        public void setDefaultStyleSheet(StyleSheet s) {
            super.setStyleSheet(s);
        }

    }
}
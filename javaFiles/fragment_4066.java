import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.*;
import javax.swing.tree.*;

public final class TextAreaEditorForJTree2 {

    public static final String INITIAL_TEXT = "Line 1\nLine 2\nLine 3";

    public static void main(String args[]) {

        JTree tree = createSimpleTree();

        addTextAreaEditor(tree);

        JScrollPane scrollPane = new JScrollPane(tree);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private static JTree createSimpleTree() {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(INITIAL_TEXT);

        for (int i = 0; i < 10; i++) {
            MutableTreeNode child = new DefaultMutableTreeNode(INITIAL_TEXT);
            root.add(child);
        }

        JTree tree = new MyJTree(root);
        tree.setRowHeight(0);  // CRITICAL - Setting to '0' means the row heights are variable and the renderer's **bounds** should be recomputed more often!
        tree.setEditable(true);
        tree.setShowsRootHandles(true);

        return tree;
    }

    private static void addTextAreaEditor(JTree tree) {
        TreeCellEditor editor = new TextAreaTableCellEditor(tree);
        tree.setCellEditor(editor);
    }

    private static final class TextAreaTableCellEditor extends AbstractCellEditor implements TreeCellEditor {

        private final JPanel editorPanel;
        private final JLabel editorLabel;
        private final JTextArea textArea;
        private DefaultMutableTreeNode currentNode;
        private final JTree tree;

        public TextAreaTableCellEditor(final JTree target) {
            this.tree = target;

            editorLabel = new JLabel("Editor:");

            textArea = new JTextArea();
            textArea.setColumns(10);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            editorPanel = new JPanel();
            BoxLayout boxLayout = new BoxLayout(editorPanel, BoxLayout.X_AXIS);
            editorPanel.setLayout(boxLayout);
            editorPanel.add(editorLabel);
            editorPanel.add(textArea);

            editorPanel.setSize(editorPanel.getPreferredSize());

            textArea.addComponentListener(new ComponentListener() {
                public void componentResized(ComponentEvent e) {somethingChanged();}
                public void componentShown(ComponentEvent e) {somethingChanged();}
                public void componentMoved(ComponentEvent e) {}
                public void componentHidden(ComponentEvent e) {}
            });

            textArea.getDocument().addDocumentListener(new DocumentListener() {
                public void insertUpdate(DocumentEvent e) {somethingChanged();}
                public void removeUpdate(DocumentEvent e) {somethingChanged();}
                public void changedUpdate(DocumentEvent e) {somethingChanged();}
            });
        }

        private void somethingChanged() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // TODO: skip if size is not changing
                    editorPanel.setSize(editorPanel.getPreferredSize());
                    ((MyJTree) tree).invalidateNodeBounds();
                    tree.repaint();
                }
            });
        }

        public Object getCellEditorValue() {
            return textArea.getText();
        }

        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        public boolean stopCellEditing() {
            currentNode.setUserObject(textArea.getText());
            return true;
        }

        public void cancelCellEditing() {
            currentNode.setUserObject(textArea.getText());
        }

        public Component getTreeCellEditorComponent(final JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
            this.currentNode = ((DefaultMutableTreeNode) value);
            textArea.setText((String) currentNode.getUserObject());
            return editorPanel;
        }
    }

    private static class MyJTree extends JTree {

        public MyJTree(TreeNode root) {
            super(root);
        }

        public void invalidateNodeBounds() {
            invalidateNodeBoundsViaSideEffect();
            //invalidateNodeBoundsViaRefection();
        }

        public void invalidateNodeBoundsViaSideEffect() {
            if (ui instanceof BasicTreeUI) {
                BasicTreeUI basicTreeUI = (BasicTreeUI) ui;
                basicTreeUI.setLeftChildIndent(basicTreeUI.getLeftChildIndent());
            }
        }

        public void invalidateNodeBoundsViaRefection() {

            if (ui instanceof BasicTreeUI) {

                try {
                    Field field = BasicTreeUI.class.getDeclaredField("treeState");
                    field.setAccessible(true);

                    AbstractLayoutCache treeState = (AbstractLayoutCache) field.get(ui);

                    if (treeState != null) {
                        treeState.invalidateSizes();
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.ToolTipManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TestTreeNodes {

    public static class SomeModelNode {
        private String value;

        public SomeModelNode(String value) {
            super();
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public class MyTreeCellRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row,
                boolean hasFocus) {
            Component cell = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            if (value instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) value;
                if (treeNode.getUserObject() instanceof SomeModelNode) {
                    setText(((SomeModelNode) treeNode.getUserObject()).getValue());
                }
            }
            return cell;
        }
    }

    private JFrame f;
    private JTree tree;
    private DefaultMutableTreeNode nodeA;
    private DefaultMutableTreeNode nodeB1;
    private DefaultMutableTreeNode nodeB2;
    private DefaultMutableTreeNode nodeC;
    private DefaultMutableTreeNode nodeD;
    private DefaultMutableTreeNode nodeE;
    private DefaultMutableTreeNode nodeF;
    private DefaultMutableTreeNode nodeH;
    private DefaultMutableTreeNode nodeK;

    private boolean showingB1 = false;

    protected void initUI() {
        tree = new JTree(getModel());
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
        ToolTipManager.sharedInstance().registerComponent(tree);
        tree.setCellRenderer(new MyTreeCellRenderer());
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(new JScrollPane(tree));
        f.pack();
        f.setVisible(true);
        Timer t = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!showingB1) {
                    tree.getSelectionModel().setSelectionPath(getPathForNode(nodeB1));
                } else {
                    tree.getSelectionModel().setSelectionPath(getPathForNode(nodeB2));
                }
                showingB1 = !showingB1;
            }
        });
        t.start();

    }

    private TreePath getPathForNode(TreeNode node) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        TreeNode current = node;
        while (current != null) {
            nodes.add(current);
            current = current.getParent();
        }
        Collections.reverse(nodes);
        return new TreePath(nodes.toArray(new Object[nodes.size()]));
    }

    private TreeModel getModel() {
        SomeModelNode a = new SomeModelNode("A");
        SomeModelNode b = new SomeModelNode("B");
        SomeModelNode c = new SomeModelNode("C");
        SomeModelNode d = new SomeModelNode("D");
        SomeModelNode e = new SomeModelNode("E");
        SomeModelNode f = new SomeModelNode("F");
        SomeModelNode h = new SomeModelNode("H");
        SomeModelNode k = new SomeModelNode("K");
        nodeA = new DefaultMutableTreeNode(a);
        nodeB1 = new DefaultMutableTreeNode(b);
        nodeB2 = new DefaultMutableTreeNode(b);
        nodeC = new DefaultMutableTreeNode(c);
        nodeD = new DefaultMutableTreeNode(d);
        nodeE = new DefaultMutableTreeNode(e);
        nodeF = new DefaultMutableTreeNode(f);
        nodeH = new DefaultMutableTreeNode(h);
        nodeK = new DefaultMutableTreeNode(k);
        // Children of A
        nodeA.add(nodeB1);
        nodeA.add(nodeB2);
        nodeA.add(nodeH);
        nodeA.add(nodeK);
        // Children of B1
        nodeB1.add(nodeC);
        nodeB1.add(nodeD);
        // Children of B2
        nodeB2.add(nodeE);
        nodeB2.add(nodeF);
        DefaultTreeModel model = new DefaultTreeModel(nodeA);
        return model;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTreeNodes().initUI();
            }
        });
    }

}
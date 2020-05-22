import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class TestTree {
    private Enumeration<TreePath> expansionState;

    public TestTree() {
        JFrame frame = new JFrame("TestTree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        final JTree tree = new JTree(buildDemoModel());

        JPanel buttonsPanel = new JPanel();

        JButton saveButton = new JButton("Capture state");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expansionState = saveExpansionState(tree);
            }
        });

        JButton loadButton = new JButton("Load state");
        loadButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loadExpansionState(tree, expansionState);
                //recapture the expansion state
                expansionState = saveExpansionState(tree);
            }

        });

        buttonsPanel.add(saveButton);
        buttonsPanel.add(loadButton);

        JPanel content = new JPanel(new BorderLayout());
        content.add(buttonsPanel, BorderLayout.SOUTH);
        content.add(new JScrollPane(tree), BorderLayout.CENTER);

        frame.add(content);
        frame.pack();
        frame.setVisible(true);
    }

    public static Enumeration<TreePath> saveExpansionState(JTree tree) {
        return tree.getExpandedDescendants(new TreePath(tree.getModel().getRoot()));
    }

    public static void loadExpansionState(JTree tree, Enumeration<TreePath> enumeration) {
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                TreePath treePath = enumeration.nextElement();
                tree.expandPath(treePath);
            }
        }
    }

    public static DefaultTreeModel buildDemoModel() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode("A");
        childNode.add(new DefaultMutableTreeNode("A1"));
        childNode.add(new DefaultMutableTreeNode("A2"));
        root.add(childNode);

        childNode = new DefaultMutableTreeNode("B");
        childNode.add(new DefaultMutableTreeNode("B1"));
        childNode.add(new DefaultMutableTreeNode("B2"));
        root.add(childNode);

        return new DefaultTreeModel(root);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestTree();
            }
        });
    }

}
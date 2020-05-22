import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.io.File;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

public class NGui {

    JFrame frame;
    private JTree tree;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                new NGui();
            }
        });
    }

    public NGui() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 212, 500);
        frame.getContentPane().add(scrollPane);

        tree = new JTree(addNodes(new File(getWorkPath())));
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);

        tree.setBorder(new LineBorder(new Color(0, 0, 0)));
        tree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);
        scrollPane.setViewportView(tree);

        tree.getSelectionModel().addTreeSelectionListener(
                new TreeSelectionListener() {
                    @Override
                    public void valueChanged(TreeSelectionEvent e) {
                        treeValueChanged(e);
                    }
                });
        tree.setCellRenderer(new FileTreeCellRenderer());

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private String getWorkPath() {
//        return System.getProperty("user.home") + "\\Program Name\\";
        return ".";
    }

    private void treeValueChanged(TreeSelectionEvent e) {
    }

    public DefaultMutableTreeNode addNodes(File dir) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(dir);
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                node.add(addNodes(file));
            } else {
                node.add(new DefaultMutableTreeNode(file));
            }
        }
        return node;
    }

    public class FileTreeCellRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            if (value instanceof DefaultMutableTreeNode) {
                value = ((DefaultMutableTreeNode)value).getUserObject();
                if (value instanceof File) {
                    value = ((File) value).getName();
                }
            }
            return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        }

    }

}
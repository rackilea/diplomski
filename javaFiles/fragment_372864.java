import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class TreeWithMultiDiscontiguousSelections {

    public static void main(String[] argv) {
        JTree tree = new JTree();
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        int treeSelectedRows[] = {3, 1};
        tree.setSelectionRows(treeSelectedRows);
        TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                JTree treeSource = (JTree) treeSelectionEvent.getSource();
                System.out.println("Min: " + treeSource.getMinSelectionRow());
                System.out.println("Max: " + treeSource.getMaxSelectionRow());
                System.out.println("Lead: " + treeSource.getLeadSelectionRow());
                System.out.println("Row: " + treeSource.getSelectionRows()[0]);
            }
        };
        tree.addTreeSelectionListener(treeSelectionListener);
        JFrame frame = new JFrame("JTree With Multi-Discontiguous selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(tree));
        frame.setPreferredSize(new Dimension(380, 320));
        frame.setLocation(150, 150);
        frame.pack();
        frame.setVisible(true);
    }

    private TreeWithMultiDiscontiguousSelections() {
    }
}
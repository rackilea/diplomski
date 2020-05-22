import java.awt.Rectangle;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class TestViewPort {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
                for (int i = 0; i < 100; i++) {
                    root.add(new DefaultMutableTreeNode(Integer.toString(i)));
                }
                JTree tree = new JTree(root);
                tree.setVisibleRowCount(10);
                JScrollPane pane = new JScrollPane();
                pane.setViewportView(tree);
                int y = tree.getPreferredSize().height;
                pane.getViewport().scrollRectToVisible(new Rectangle(0, y, 0, 0));
                JOptionPane.showMessageDialog(null, pane);
            }  
        });
    }
}
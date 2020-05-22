import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreeTest {

    public static void main(String[] args) {
        new TreeTest();
    }

    public TreeTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JDesktopPane desktopPane = new JDesktopPane();
                JInternalFrame inFrame = new JInternalFrame("Tree", true, true, true, true);
                inFrame.add(new TestPane());
                inFrame.pack();
                inFrame.setVisible(true);
                desktopPane.add(inFrame);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(desktopPane);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());

            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Deck");
            DefaultMutableTreeNode itemClubs = new DefaultMutableTreeNode("Clubs");
            root.add(itemClubs);
            DefaultMutableTreeNode itemDiamonds = new DefaultMutableTreeNode("Diamonds");
            root.add(itemDiamonds);
            DefaultMutableTreeNode itemSpades = new DefaultMutableTreeNode("Spades");
            root.add(itemSpades);
            DefaultMutableTreeNode itemHearts = new DefaultMutableTreeNode("Hearts");
            root.add(itemHearts);
            DefaultTreeModel treeModel = new DefaultTreeModel(root);
            JTree tree = new JTree(treeModel);
//            tree.setRootVisible(true);
//            tree.setShowsRootHandles(true);

            JPanel topPanel = new JPanel(new BorderLayout());
            topPanel.add(new JScrollPane(tree));
            add(topPanel);
        }

    }

}
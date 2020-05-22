import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.tree.*;

public class FrmMain extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmMain frame = new FrmMain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FrmMain() {
        setTitle("HelloJTree3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JButton btnNewButton = new JButton("Click Me");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                doClick ();
            }
        });
        contentPane.add(btnNewButton, BorderLayout.NORTH);
        jarFilesDB = new JarFilesDB ();
        jarFilesDB.load(isAlpha);
        isAlpha = !isAlpha;
        //jtree = new JTree(jarFilesDB.getRootNode ());
        jtree = new JTree(jarFilesDB);
        JScrollPane scrollPane = new JScrollPane (jtree);
        contentPane.add(scrollPane, BorderLayout.CENTER); 
    }

    private void doClick () {
        jarFilesDB.load(isAlpha);
        isAlpha = !isAlpha;
    }

    private JarFilesDB jarFilesDB;
    private JTree jtree;
    private boolean isAlpha = false;
}

class JarFilesDB extends DefaultTreeModel {

    public JarFilesDB () {
        super (new DefaultMutableTreeNode("root"));
        rootNode = (DefaultMutableTreeNode) getRoot(); 
    }

    public void load (boolean isAlpha) {
        rootNode.removeAllChildren ();

        String[] values;
        if (isAlpha)
            values = new String[] {"A", "A1", "A2", "B", "B1", "B2"};
        else
            values = new String[] {"10", "11", "12", "20", "21", "22"};

        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode (values[0]);
        DefaultMutableTreeNode leafNode = new DefaultMutableTreeNode (values[1]);
        childNode.add(leafNode);
        leafNode = new DefaultMutableTreeNode (values[2]);
        childNode.add(leafNode);

        rootNode.add(childNode);

        childNode = new DefaultMutableTreeNode (values[3]);
        leafNode = new DefaultMutableTreeNode (values[4]);
        childNode.add(leafNode);
        leafNode = new DefaultMutableTreeNode (values[5]);
        childNode.add(leafNode);
        rootNode.add(childNode);

        nodeStructureChanged(rootNode);
    }

    public TreeNode getRootNode () {
        return rootNode;
    }

    private DefaultMutableTreeNode rootNode = null;

}
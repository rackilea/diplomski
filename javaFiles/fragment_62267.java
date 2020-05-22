import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;

/**
 * Created by keshan on 7/26/2016.
 */
public class FileBrowser implements Runnable {

    private DefaultMutableTreeNode root;

    private DefaultTreeModel treeModel;

    private JTree tree;

    @Override
    public void run() {
        JFrame frame = new JFrame("File Browser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        File fileRoot = new File("C:");
        root = new DefaultMutableTreeNode(new FileNodes(fileRoot));
        treeModel = new DefaultTreeModel(root);

        tree = new JTree(treeModel);
        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            private Icon loadIcon = UIManager.getIcon("OptionPane.errorIcon");
            private Icon saveIcon = UIManager.getIcon("OptionPane.informationIcon");
            @Override
            public Component getTreeCellRendererComponent( JTree tree,
                                                           Object value,
                                                           boolean bSelected,
                                                           boolean bExpanded,
                                                           boolean bLeaf,
                                                           int iRow,
                                                           boolean bHasFocus ) {
                Component c = super.getTreeCellRendererComponent(tree, value,
                        bSelected, bExpanded, false, iRow, bHasFocus);

                return c;
            }
        });
        tree.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree);

        frame.add(scrollPane);
        frame.setLocationByPlatform(true);
        frame.setSize(640, 480);
        frame.setVisible(true);

        CreateChildNode ccn = new CreateChildNode(fileRoot, root);
        new Thread(ccn).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new FileBrowser());
    }
}

class CreateChildNode implements Runnable {

    private DefaultMutableTreeNode root;

    private File fileRoot;

    public CreateChildNode(File fileRoot, DefaultMutableTreeNode root) {
        this.fileRoot = fileRoot;
        this.root = root;
    }

    @Override
    public void run() {
        createChildren(fileRoot, root);
    }

    private void createChildren(File fileRoot, DefaultMutableTreeNode root)
    {
        File[] files = fileRoot.listFiles();
        if ( files != null )
        {
            for( File child : files )
            {
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode( new FileNodes( child ) );
                if( child.isDirectory() )
                {
                    root.add( childNode );
                    createChildren( child, childNode );
                }
            }
        }
    }

}

class FileNodes {

    private File file;

    public FileNodes(File file) {
        this.file = file;
    }
    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        String name = file.getName();
        if (name.equals("")) {
            return file.getAbsolutePath();
        } else {
            return name;
        }
    }
}
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class TreeFileSystem extends JPanel
    implements ActionListener, TreeWillExpandListener, TreeSelectionListener
{
    private int fileIndex;

    private JTree tree;
    private DefaultTreeModel model;

    private JTextField textField;

    public TreeFileSystem()
    {
        super(new BorderLayout());

        textField = new JTextField("..\\");
        textField.addActionListener( this );
        add(textField, BorderLayout.NORTH);

        tree = new JTree( new DefaultMutableTreeNode() );
        JScrollPane scrollPane = new JScrollPane( tree );
        add(scrollPane);

        tree.addTreeWillExpandListener( this );
        tree.addTreeSelectionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        File file = new File( textField.getText() );

        if (file.exists())
        {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode( file );
            model = new DefaultTreeModel( root );
            addNodes(root, true);
            tree.setModel( model );
        }
    }

    private void addNodes(DefaultMutableTreeNode root, boolean addChildNodes)
    {
        File file = (File)root.getUserObject();

        if (!file.isDirectory()) return;

        File[] files = file.listFiles();

        if (files == null) return;

        int directoryInsert = 0;

        for (int i = 0; i < files.length; i++)
        {
            file = files[i];
            DefaultMutableTreeNode node = new MyDefaultMutableTreeNode( file );

            if (file.isDirectory())
                root.insert(node, directoryInsert++);
            else
                root.insert(node, i);

            if (addChildNodes)
                addNodes(node, false);
        }
    }

    public void treeWillExpand(TreeExpansionEvent e) throws ExpandVetoException
    {
        if (tree.hasBeenExpanded(e.getPath())) return;

        TreePath path = e.getPath();

        if (path.getPathCount() == 2) return;

        DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getPathComponent( path.getPathCount() - 1);
        addNodes(node, false);
    }

    public void treeWillCollapse(TreeExpansionEvent e) {}


    public void valueChanged(TreeSelectionEvent e)
    {
        final DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

        if (root == null) return;


        ActionListener al = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                File file = new File("file" + fileIndex++);
                System.out.println(file);
                DefaultMutableTreeNode node = new MyDefaultMutableTreeNode(file);
//              root.insert(node, 0);
//              model.reload(root);
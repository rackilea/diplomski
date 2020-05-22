import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JToolTip;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;


public class Main 
{

    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Tooltip Example");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Node root = new Node("Root", "Root Tooltip");
        MyTree tree = new MyTree(root);
        root.add(new Node("Child 1", "Tooltip 1"));
        root.add(new Node("Child 2", "Tooltip 2"));
        tree.setToolTipText(""); // The correct tooltips will be shown on each node.
        frame.add(tree);

        frame.setVisible(true);
    }   

}

class Node extends DefaultMutableTreeNode
{
    String toolTip;

    public Node(String name, String toolTip)
    {
        super(name);
        this.toolTip = toolTip;
    }
    public String getToolTipText() 
    {
        return toolTip;
    }
}

class MyTree extends JTree
{
    MyTree(TreeNode node)
    {
        super(node);
    }

    @Override
    public JToolTip createToolTip() 
    {
        JToolTip tooltip = super.createToolTip();
        tooltip.setBorder(BorderFactory.createLineBorder(new Color(76,79,83)));
        tooltip.setBackground(new Color(255, 247, 200));  
        return tooltip;
    }

    @Override
    public String getToolTipText(MouseEvent event) 
    {
        super.getToolTipText(event);
        if(getRowForLocation(event.getX(), event.getY()) == -1)
            return null;
        TreePath path = getPathForLocation(event.getX(), event.getY());
        return ((Node) path.getLastPathComponent()).getToolTipText();
    }

}
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class MyTree extends JFrame{

private JTree tree;
private DefaultTreeModel model;
private DefaultMutableTreeNode rootNode;


public MyTree()
{
     DefaultMutableTreeNode philosophersNode = getTree();
        model = new DefaultTreeModel(philosophersNode);
        tree = new JTree(model);
        JButton addButton = new JButton("Add ");
        addButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            addNode();
          }
        });
        JButton removeButton = new JButton("Delete");
        removeButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
              removeSelectedNode();
          }
        });
        JPanel inputPanel = new JPanel();
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        Container container = getContentPane();

        container.add(new JScrollPane(tree), BorderLayout.CENTER);

        container.add(inputPanel, BorderLayout.NORTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setVisible(true);

}

 private DefaultMutableTreeNode getSelectedNode() {

        return (DefaultMutableTreeNode)   tree.getLastSelectedPathComponent();
      }

 private DefaultMutableTreeNode getTree() {
         rootNode = new DefaultMutableTreeNode("Root");
        return rootNode;
      }

 private void removeSelectedNode() {
        DefaultMutableTreeNode selectedNode = getSelectedNode();
        if (selectedNode != null){
             if(selectedNode.toString()=="Root")
                {
                     JOptionPane.showMessageDialog(MyTree.this, "Cannot delete root element", "Error",
                              JOptionPane.ERROR_MESSAGE);
                }else{

          model.removeNodeFromParent(selectedNode);
                }
        }

      }

 private void addNode() {
        DefaultMutableTreeNode parent = getSelectedNode();
        if (parent == null) {
          JOptionPane.showMessageDialog(MyTree.this, "Select an area.",   "Error",
              JOptionPane.ERROR_MESSAGE);

          return;
        }
        String name = JOptionPane.showInputDialog(MyTree.this, "Enter Name:");
        model.insertNodeInto(new DefaultMutableTreeNode(name), parent,     parent.getChildCount());

      }

 public static void main(String args[]) {
        new MyTree();
      }

}
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TestFrame extends JFrame {

    private JTree t;

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode bird = new DefaultMutableTreeNode("Birds");
        root.add(bird);

        DefaultTreeModel model = new DefaultTreeModel(root);
        add(t=new JTree(model));

        JButton btn = new JButton("add");
        btn.addActionListener(getAddListener());

        add(btn,BorderLayout.SOUTH);
    }

    private ActionListener getAddListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTreeModel model = (DefaultTreeModel)t.getModel();
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

                Enumeration children = root.children();
                while(children.hasMoreElements()){
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) children.nextElement();
                    if(node.toString().equals("Birds")){

                        DefaultMutableTreeNode sparrow = new DefaultMutableTreeNode("sparrow");
                        DefaultMutableTreeNode cuckoo = new DefaultMutableTreeNode("cuckoo");

                        node.add(sparrow);
                        node.add(cuckoo);
                        model.nodesWereInserted(node, new int[]{node.getChildCount()-1,node.getChildCount()-2});
                        break;
                    }
                }


            }
        };
    }

    public static void main(String args[]) {
        new TestFrame();
    }

}
import javax.swing.*;
import javax.swing.tree.*;

class MainClass extends JFrame {

    private JSplitPane splitPan=null;

    private void treePanel(){
        DefaultMutableTreeNode nod=new DefaultMutableTreeNode("AAA",true);
        nod.add(new DefaultMutableTreeNode("abcd"));
        JTree tree=new JTree(nod);
        JScrollPane scroll=new JScrollPane(tree);
        splitPan=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,new JLabel("aaaaa"));
        splitPan.setSize(this.getMaximumSize());
        add(splitPan);
    }

    public MainClass() {
        // this is it!
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        treePanel();
        add(new JButton("btn"));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainClass();
            }
        });
    }
}
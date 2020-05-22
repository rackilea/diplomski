import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class TestFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public TestFrame()  {
        super("Top Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());

        JTree env = getEnvironmentTree();
        env.expandRow(0);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx=.7;
        c.weighty=1;

        c.gridx=0;
        c.gridy=0;
        c.gridheight=1;
        c.gridwidth=7;
        panel.add(new JScrollPane(env),c);

        c.weightx=.3;
        c.gridx=7;
        c.gridy=0;
        c.gridheight=1;
        c.gridwidth=GridBagConstraints.REMAINDER;
        panel.add(new JTextArea("Some contents"),c);

        add(panel);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JTree getEnvironmentTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        JTree tree = new JTree(root);
        DefaultMutableTreeNode one = new DefaultMutableTreeNode("One");
        root.add(one);
        one.add(new DefaultMutableTreeNode("under one.1"));
        one.add(new DefaultMutableTreeNode("under one.2"));
        root.add(new DefaultMutableTreeNode("two"));
        root.add(new DefaultMutableTreeNode("three"));
        return tree;
    }

    public static void main(String[] args) {
        new TestFrame();
    }
}
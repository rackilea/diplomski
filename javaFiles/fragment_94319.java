public class Frame1 extends JFrame {
    private JTree jtree = new JTree();

    public Frame1() {
        jtree.addTreeSelectionListener(new JTreeSelectionListener(jtree));
    }
}

public class JTreeSelectionListener implements TreeSelectionListener {
    private JTree jtree;

    public JTreeSelectionListener(JTree jtree) {
        this.jtree = jtree;
    }

    public void valueChanged(TreeSelectionEvent e) {
    }
}
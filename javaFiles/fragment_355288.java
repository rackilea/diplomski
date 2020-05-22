public class SplitPane extends JFrame {

  private MutableTreeNode createTree() {
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
    root.add(new DefaultMutableTreeNode("child 1"));
    root.add(new DefaultMutableTreeNode("child 2"));

    return root;
  }

  public SplitPane() {

    setSize(600, 400);

    // create model and add nodes
    TreeModel model = new DefaultTreeModel(createTree());

    // initialize tree, set the model
    JTree tree = new JTree(model);
    tree.setRootVisible(false);

    JScrollPane leftScrollPane = new JScrollPane(tree);
    JScrollPane rightScrollPane = new JScrollPane(new JLabel("Text ..."));

    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    splitPane.setLeftComponent(leftScrollPane);
    splitPane.setRightComponent(rightScrollPane);
    splitPane.setDividerLocation(200);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().add(splitPane);
    this.setVisible(true);
  }
}
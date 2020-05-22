JFrame frame = new JFrame();

   ///adding mock data
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
    for (int i = 1; i < 5; i++) {
        DefaultMutableTreeNode parent = new DefaultMutableTreeNode("Parent" + i);
        for (int j = 1; j < 5; j++) {
            parent.add(new DefaultMutableTreeNode("Child" + j));
        }
        root.add(parent);
    }

    DefaultTreeModel model = new DefaultTreeModel(root);
    JTree tree = new JTree(model);

    tree.setRootVisible(false);//To hide root

    frame.add(new JScrollPane(tree));
    frame.setTitle("Tree RootHide Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
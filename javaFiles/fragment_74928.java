DefaultMutableTreeNode root = new DefaultMutableTreeNode("Hello");
DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Goodbye");
DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Bonjour");

root.add(child1);
root.add(child2);

JTree tree = new JTree(root);
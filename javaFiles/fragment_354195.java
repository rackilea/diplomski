DefaultMutableTreeNode child = new DefaultMutableTreeNode("String");
DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("String");
DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("String1");

addUniqueNode(child, model);  // Will get added
addUniqueNode(child1, model); // Will not get added
addUniqueNode(child2, model); // Will get added
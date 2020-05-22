final JTree tree = new JTree();
TreeModel model = tree.getModel();
if (model instanceof DefaultTreeModel) {
    DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
    treeModel.setRoot(root);
}
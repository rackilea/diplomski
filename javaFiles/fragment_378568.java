/**
 * Removes all nodes from the supplied JTree except the Root.
 * 
 * @param tree (JTree) The JTree Variable Name for which to 
 * clear all nodes from.
 */
public static void clearTree(JTree tree) {
    if (tree.toString() == null) { return; }
    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
    DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
    root.removeAllChildren();
    model.reload();
}
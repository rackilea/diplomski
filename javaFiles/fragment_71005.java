class MyTreeModelListener implements TreeModelListener {
public void treeNodesChanged(TreeModelEvent e) {
    MyTreeNode node;
    node = (MyTreeNode)
             (e.getTreePath().getLastPathComponent());

    /*
     * If the event lists children, then the changed
     * node is the child of the node we have already
     * gotten.  Otherwise, the changed node and the
     * specified node are the same.
     */
    try {
        int index = e.getChildIndices()[0];
        node = (MyTreeNode)
               (node.getChildAt(index));
    } catch (NullPointerException exc) {}

    System.out.println("The user has finished editing the node.");
    System.out.println("New value: " + node.getUserObject());
}
public void treeNodesInserted(TreeModelEvent e) {
}
public void treeNodesRemoved(TreeModelEvent e) {
}
public void treeStructureChanged(TreeModelEvent e) {
}
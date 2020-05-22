public void fireTreeNodesChanged(TreePath path) {
    TreeModelEvent e = new TreeModelEvent(this, path.getPath());
    for (TreeModelListener l : treeModelListeners) {
        l.treeNodesChanged(e);
    }
}
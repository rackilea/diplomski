@Override
public Component getTreeCellRendererComponent(JTree tree,
    Object value, boolean selected, boolean expanded,
    boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected,expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
        if (tree.getModel().getRoot().equals(nodo)) {
            setIcon(root);
        } else if (nodo.getChildCount() > 0) {
            setIcon(parent);
        } else {
            setIcon(leaf);
        }
        return this;
}
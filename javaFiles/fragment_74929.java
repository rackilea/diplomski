TreeCellRenderer renderer = new DefaultTreeCellRenderer() {
  public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
    // Defer to superclass to create initial version of JLabel and then modify (below).
    JLabel ret = (JLabel) super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

    // We know that value is a DefaultMutableTreeNode so this downcast is safe.
    MutableTreeNode node = (MutableTreeNode) value;

    // Inspect user object and change rendering based on this.
    if ("Hello".equals(node.getUserObject())) {
      ret.setIcon(...);
    }

    // Could also inspect whether node is a leaf node, etc.
    return ret;
  }
};
public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus){
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
    walkThroug(node, isSelected);
}

private void walkThrough(DefaultMutableTreeNode node, boolean isSelected) {
    int cc = node.getChildCount();

    //TODO select current node
    //something like: node.setSelected(isSelected)

    for(int i = 0; i < cc; i++){
        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
        walkThrough(childNode, isSelected);
    }
}
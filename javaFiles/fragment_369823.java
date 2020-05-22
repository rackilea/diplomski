private static DefaultMutableTreeNode searchTree(DefaultMutableTreeNode root, Object[] path) {
    if (!root.getUserObject().equals(path[0])) {
        // completely different root
        // potentially problematic
        return null;
    }

    DefaultMutableTreeNode node = root;
    for (int i = 1; i < path.length; ++i) {
        Object searchItem = path[i];
        Enumeration<TreeNode> children = node.children();
        boolean found = false;
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
            if (searchItem.equals(child.getUserObject())) {
                found = true;
                node = child;
                break;
            }
        }

        if (!found) {
            // path does not exist any more
            // potentially problematic
            return null;
        }
    }

    return node;
}
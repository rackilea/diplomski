private TreePath findNewSelectionPath(TreePath oldSelectionPath) {
    TreePath newSelectionPath = null;

    if(oldSelectionPath != null) {
        Object[] oldPathComponents = oldSelectionPath.getPath();
        Object[] newPathComponents = new Object[oldPathComponents.length];

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) filteredModel.getRoot();

        // Set the root
        if(oldPathComponents[0].equals(node)) {
            newPathComponents[0] = node;
        }

        // Set the rest of the path components
        for(int n = 1; n < oldPathComponents.length; n++) {
            for(int k = 0; k < node.getChildCount(); k++) {
                if(oldPathComponents[n].equals(node.getChildAt(k))) {
                    newPathComponents[n] = node.getChildAt(k);
                    node = node.getChildAt(k);
                    break;
                }
            }
        }

        // Make sure that the last path component exists
        if(newPathComponents[newPathComponents.length - 1] != null) {
            newSelectionPath = new TreePath(newPathComponents);
        }
    }
    return newSelectionPath;
}
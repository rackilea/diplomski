public TreeNode<T> split() {
    // Create a new root node for the tree we split off
    TreeNode<T> tn = new TreeNode<T>(data);
    tn.children = children;
    tn.elementsIndex = elementsIndex;

    // For each level of the tree above us make sure we remove
    // ourselves from the elementsIndex at EACH LEVEL until we
    // finish at the root.
    TreeNode<T> tP = this;
    while (tP.isRoot() == false) {
        tP = tP.parent;
        tP.elementsIndex.remove(this);
    }

    // If this node has a parent remove this node as one of
    // our parent's children. We aren't the child of any of the
    // levels above our parent
    if (parent != null)
        this.parent.children.remove(this);

    // Return the root of the newly split tree
    return tn;
}
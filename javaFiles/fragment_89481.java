/**
 * Returns the index of child in parent.
 */
public int getIndexOfChild(Object parent, Object child) {
    return rootPerson.getIndex((DefaultMutableTreeNode) child);
}
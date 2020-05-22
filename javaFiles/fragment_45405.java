/**
 * Checks whether the given node is an ancestor of this node.
 */
public boolean isDescendantOf(Node ancestor) {
    Preconditions.checkNotNull(ancestor, "Ancestor");
    if (equals(ancestor)) {
        // every node is an ancestor to itself
        return true;
    } else if (parent == null) {
        // not related
        return false;
    } else {
        // recursive call
        return parent.isDescendantOf(ancestor);
    }
}
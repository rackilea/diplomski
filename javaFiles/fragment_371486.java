if (child != null) { 
    if (check(child, label))
        return child; // match found
    TreeNode childResult = child.getNodeReference(label);
    if (childResult != null)
        return childResult; // match found deeper in tree; this is what you did not do.
}
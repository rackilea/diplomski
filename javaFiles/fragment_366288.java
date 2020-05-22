public static Node lookup(Node node, int lookupValue) {
    if (node == null)
        return null;
    if (node.value == lookupValue)
        // System.out.println("Found");
        return node;
    Node rval = lookup(node.left, lookupValue);
    // only return if found in left sub-tree
    return (rval != null) ? rval : lookup(node.right, lookupValue);
}
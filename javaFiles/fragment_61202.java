public boolean find(String str) {

    LinkedList<Node> children = root.getChildren();
    // start the node at the root
    Node node = root;
    char[] chars = str.toCharArray();
    //Loop over all letters.
    for (int i = 0; i < chars.length; i++) {
        char c = chars[i];
        //If child contains c.
        if (childContain(children, String.valueOf(c))) {
            //get the child *of the node, not root* and it's children.
            node = getChild(node, c);

            // there are better ways to handle this, but I think this explicitly shows what the situations is
            if (node == null) {
                // we have reached a node that does not have children
                if (i == chars.length - 1) {
                    // we are at the end of the word - it is found
                    return true;
                } else {
                    // we are in the middle of the word - it is not present
                    return false;
                }
            }

            // if we have reached the end of the word this will cause NullPointer
            children = node.getChildren();

        } else {
            return false;
        }
    }
    return true;
}
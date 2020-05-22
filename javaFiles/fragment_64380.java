int indexOfNode(Node node) {
    int index;
    Node sibling;

    index = 0;
    while ((sibling = node.getPreviousSibling()) != null) {
        node = sibling;
        ++index;
    }

    return index;
}
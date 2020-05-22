if (node == null) {
    return (new Node(insert_value));
}
else {
    if (node.getNodeValue() < insert_value)
        node = insertNode(node.getLeftNode(), insert_value);
    else
        node = insertNode(node.getRightNode(), insert_value);

    return (node);
}
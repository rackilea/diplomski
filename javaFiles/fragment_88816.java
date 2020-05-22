private Node<T> searchAux(Node<T> node, T key){
    if(node == null) 
        return null;
    if (node.getElem() == key)
        return node;
    if (node.getChild() != null) {
        Node<T> foundNode = searchAux(node.getChild(), key);
        if (foundNode != null)
            return foundNode;
    } 
    return searchAux(node.getSibling(), key);
}
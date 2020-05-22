public Node() { 

}

public Node(E nVal) { 
    nodeValue = nVal; 
}

public Node(E nVal, Node<E> nextNode) {
    nodeValue = nVal;
    next = nextNode;
}
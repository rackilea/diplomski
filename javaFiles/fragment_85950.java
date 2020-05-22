for ( SomeData data : ... ) {
    SomeData parent = data.getParent();
    Node<SomeData> parentNode = getOrCreateNode(parent);
    Node<SomeData> childNode = getOrCreateNode(data);
    parentNode.addChild(childNode);
}

private Node<SomeData> getOrCreateNode(SomeData data) {
    Node<SomeData> node = visitedNodes.get(data.getID());
    if ( node == null ) {
       node = new Node<SomeData>(data);
       visitedNodes.put(data.getID(), node);
    }
    return node;
}
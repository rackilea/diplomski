private void addConnection(Node newConnection) {
    connections.add(newConnection);
}

public void addNode(Node newNode) {
    addConnection(newNode);
    newNode.addConnection(this);
}
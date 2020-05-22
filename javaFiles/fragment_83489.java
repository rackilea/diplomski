public Node makeNode(String name){
    Node newNode;
    newNode = new Node();
    newNode.dataitems = name;
    newNode.next = null;
    return newNode;
}
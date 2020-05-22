public List<Node> populateDijkstraFrom(Node startNode) {
       // ^ Configure to return list instead of void

    // ......
    return nodeList;
}

public List<Node> getShortestPath(Node startNode, Node targetNode) {
    List<Node> pdList = populateDijkstraFrom(startNode);
    // ^ --- Get the list by simply passing the same parameter to the method
}
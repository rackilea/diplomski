private List<Node> constructPath(Map<Node,Node> predecessors,
                                 Node startNode, Node finishNode) {
/*
    // use predecessors to work backwards from finish to start,
    // all the while dumping everything into a linked list
    List<Node> path = new LinkedList<Node>();

    if(predecessors.containsKey(finishNode)) {
        Node currNode = finishNode;
        while (currNode != startNode) {
            path.add(0, currNode);
            currNode = predecessors.get(currNode);
        }
        path.add(0, startNode);
    }
*/
    Set<Node> prereqs = new HashSet<Node>(predecessors.keySet());
    prereqs.remove(graph.get("None"));
    return new ArrayList<Node>(prereqs);
}
interface AbstractNode {
    // identify this node
    // this class only contains the ID of this node
}

interface GraphEditor<T extends AbstractNode> {
    // this class stores the graph
    void addEdge(T a, T b);
}
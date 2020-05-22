class Node {}
class Edge {
    Node getNode();
}

class GraphicalNode extends Node {}
class GraphicalEdge extends Edge {
    // This really overrides the method, with a more specific return type!
    @Override
    GraphicalNode getNode();
}
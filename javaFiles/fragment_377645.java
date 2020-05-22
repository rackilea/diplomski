interface Node {}
interface Edge { 
    Node getNode();
}

interface GraphicalNode extends Node {}
interface GraphicalEdge extends Edge { 
    @Override
    GraphicalNode getNode();
}

class DefaultEdge implements GraphicalEdge { ... }
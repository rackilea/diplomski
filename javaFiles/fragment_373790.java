abstract public class Node {
    private int position; //Every Node can have a position
}

public class InnerNode extends Node { //Renamed for clarity
    List<Node> children; //Children can be InnerNodes or Leafs 
}

abstract public class LeafNode extends Node {
    //As this is no longer an extension of InnerNode, it won't have the children field.
}
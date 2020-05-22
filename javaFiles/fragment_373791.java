abstract public class Node {
    private int position; //Every Node can have a position

    public abstract List<Node> getChildren();
}

public class InnerNode extends Node { //Renamed for clarity
    List<Node> children; //Children can be InnerNodes or Leafs 

    public List<Node> getChildren(){
        return new ArrayList<>(children);
    }
}

abstract public class LeafNode extends Node {
    //As this is no longer an extension of InnerNode, it won't have the children field.

    public List<Node> getChildren() {
        return new ArrayList<>(); //Empty
    }
}
public class Graph {
    Set<Node> nodes = new HashSet<Node>();
    public void addNode(Node n) {
        // note: this assumes you've properly overridden 
        // equals and hashCode in Node to make Nodes with the 
        // same name .equal() and hash to the same value.
        if(nodes.contains(n)) {
            throw new IllegalArgumentException("Already in graph: " + node);
        }
        nodes.add(n);
    }
}
class Node {
    private final int id;
    private final List<Node> linkedNodes = new ArrayList<>();

    public Node(int id) {
        this.id = id;
    }

    public void addLink(Node linkNode) {
        linkedNodes.add(linkNode);
    }
}

class Graph {
    private final Map<Integer, Node> nodes = new HashMap<>();
    public addLink(int id1, int id2) {
        getNode(id1).addLink(getNode(id2));
        getNode(id2).addLink(getNode(id1));
    }

    private getNode(int id) {
        if (!nodes.containsKey(id)) {
            nodes.add(new Node(id));
        }
        return nodes.get(id);
    }
}
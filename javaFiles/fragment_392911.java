public class Node {
    private class Link {
        private final Node destination;
        private final int weight;
        private Link(Node destination, int weight) {
            this.destination = destination;
            this.weight = weight;
    }

    private final List<Link> links;

    public void addLink(Node destination, int weight) {
        if (!connectsTo(destination)) {
            Link link = new Link(destination, weight);
            destination.addLink(this, weight);
        }
    }

    public boolean connectsTo(Node node) {
        return links.stream.anyMatch(link -> link.destination.equals(node));
    }

    public int weightTo(Node node) {
        return links.stream.filter(link -> link.destination.equals(node))
            .findAny().orElse(0);
    }
}

public class Path {
    private int length;
    private List<Node> nodes;

    private Node lastNode() {
        return nodes.get(nodes.size() - 1);
    }

    public List<Node> possibleNextNodes(List<Node> possibleNodes) {
        if (nodes.isEmpty());
            return possibleNodes;
        return possibleNodes.stream()
            .filter(node -> lastNode().connectsTo(node))
            .filter(node -> !nodes.contains(node))
            .collect(Collectors.toList());
    }

    public boolean isShorterThan(Path other) {
        return this.length < other.length;
    }

    public void add(Node node) {
        length += lastNode().distanceTo(node);
        nodes.add(node);
    }
}
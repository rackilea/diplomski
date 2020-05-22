public class DijkstraNode {
    private int label;
    private List<DijkstraLink> links;

    public DijkstraNode(int label) {
        this.label = label;
        links = new ArrayList<DijkstraLink>();
    }

    public int getLabel() {
        return label;
    }

    public void addLink(DijkstraLink link) {
        links.add(link);
    }

    public List<DijkstraLink> getLinks() {
        return links;
    }
}

...

public class DijkstraLink {
    private DijkstraNode node;
    private int distance;

    public DijkstraLink(DijkstraNode node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public DijkstraNode getLinkedNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }
}
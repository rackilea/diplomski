@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
class Node {
    private MainNode    mainNode;
    private MainNode2   mainNode2;

    public Node() {
    }

    public Node(MainNode mainNode, MainNode2 mainNode2) {
        this.mainNode = mainNode;
        this.mainNode2 = mainNode2;
    }

}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
class MainNode {
    private String  node1;
    private String  node2;

    public MainNode() {
    }

    public MainNode(String node1, String node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
class MainNode2 {

}
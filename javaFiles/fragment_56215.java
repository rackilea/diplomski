class NodeCollection {
    private INode[] nodes = new INode[42];

    public <T extends INode> T getNode(final int offset) {
        return (T) nodes[offset];
    }

    public <T extends INode> setNode(final int offset, T node) {
        nodes[offset] = node;
    }
}

class ANode implements INode {}
class BNode implements INode {
    void foo();
}

public class Test {
    public static void main(String[] args) {
        NodeCollection nc = new NodeCollection();
        nc.setNode(0,new ANode());
        BNode b = nc.getNode(0); // throws ClassCastException (sic!)
    }
}
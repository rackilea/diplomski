import java.util.HashSet;

public class Node
{
    private HashSet<Node> nextNodes = new HashSet<Node>();

    public Node()
    {
    }

    public void addNextNode(Node node)
    {
        nextNodes.add(node);
    }

    public static void main(String[] args)
    {
        // this builds the graph of connected nodes
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();

        a.addNextNode(b);
        b.addNextNode(c);
        c.addNextNode(a);

        //this is the set that will lsit all nodes:
        HashSet<Node> allNodes = new HashSet<Node>();

        // this goes through the graph
        a.listAllNodes(allNodes);

        System.out.println(allNodes);
    }

    private void listAllNodes (HashSet<Node> listOfNodes)
    {
        // try to put all next nodes of the node into the list:
        for(Node n : nextNodes)
        {
            if (listOfNodes.add(n))          // the set returns true if it did in fact add it.
                n.listAllNodes(listOfNodes); // recursion
        }

    }
}
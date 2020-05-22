public class WhatIsCovariance
{
    public static void main(String[] args)
    {
        Node n0 = new Node();
        Node n1 = new Node();
        Edge e0 = new Edge(n0, n1);

        Node n = e0.getNode0(); // Works


        GraphicalNode gn0 = new GraphicalNode();
        GraphicalNode gn1 = new GraphicalNode();
        GraphicalEdge ge0 = new GraphicalEdge(gn0, gn1);

        GraphicalNode gn = ge0.getNode0(); // Works
    }
}

class Node
{
    private String label;
}

class Edge
{
    private Node node0;
    private Node node1;

    Edge(Node node0, Node node1)
    {
        this.node0 = node0;
        this.node1 = node1;
    }

    public Node getNode0()
    {
        return node0;
    }

    public Node getNode1()
    {
        return node1;
    }
}

class GraphicalNode extends Node
{
    private int x;
    private int y;
}

class GraphicalEdge extends Edge
{
    private GraphicalNode node0;
    private GraphicalNode node1;

    GraphicalEdge(GraphicalNode node0, GraphicalNode node1)
    {
        super(node0, node1);

        this.node0 = node0;
        this.node1 = node1;
    }

    @Override
    public GraphicalNode getNode0()
    {
        return node0;
    }

    @Override
    public GraphicalNode getNode1()
    {
        return node1;
    }

}
class Node implements Cloneable
{
    public int x;

    Node(int x) { this.x = x; }

    @Override
    public String toString() { return Integer.toString(x); }

    @Override
    protected Node clone() throws CloneNotSupportedException
    {
        Node copy = null;
        copy = (Node)super.clone();
        return copy;
    }
}
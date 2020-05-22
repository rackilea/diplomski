public class Node
{
    private String x;
    private int y;
    private int z;

    public Node(String x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return x + "/" + y + "/" + z;
    }
}
public class Icosahedron {

    private double edge;
    private int count;

    public Icosahedron(int count) {
        this.count = count;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Icosahedron{edge=" + edge + ", count=" + count + '}';
    }

}
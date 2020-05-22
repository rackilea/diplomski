public class Helper implements Comparable{

    Iris iris;
    double distance;

    public Helper(Iris iris, double distance) {
        this.iris = iris;
        this.distance = distance;
    }

    public int compareTo(Helper other) {
        return new Double(this.distance).compareTo(new Double(other.distance));

    }
}
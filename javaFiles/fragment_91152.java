import java.lang.Comparable;
abstract class Int implements Comparable<Int> {
    private int x;
    public Int(int x) {
        this.x = x;
    }
    @Override
    public int compareTo(Int other) {
        return x - other.x;
    }
    @Override
    public String toString() {
        return Integer.toString(x);
    }
}
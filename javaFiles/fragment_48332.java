public class Point {
    final int x, y ;
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != Point.class) {
            return false ;
        }
        Point o = (Point)other ;
        return o.x == x && o.y == y ;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
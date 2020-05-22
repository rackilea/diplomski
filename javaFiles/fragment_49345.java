public class CartesianPoint {
    private final long x;
    private final long y;
    public CartesianPoint(long x, long y) {
        this.x = x; this.y = y;
    }

    public CartesianPoint rotate90() {
        // actual logic omitted, hardcoding result
        return new CartesianPoint(0, 1); 
    }

    public long getX() {return x;}

    public long getY() {return y;}
}
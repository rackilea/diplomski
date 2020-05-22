private static final int N_POINTS = 10191; // or some large prime.
private static final Point[] POINTS = new Point[N_POINTS];

public static Point of(int x, int y, int z) {
    int h = hash(x,y,z); // a simple hash function of x,y,z
    int index = (h & 0x7fffffff) % N_POINTS;
    Point p = POINTS[index];
    if (p != null && p.x == x && p.y == y && p.z == z)
       return p;
    return POINTS[index] = new Point(x,y,z);
}
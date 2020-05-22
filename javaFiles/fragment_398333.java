public static void swapPoints(Point p1, Point p2) {
    p1.x ^= p2.x;
    p2.x ^= p1.x;
    p1.x ^= p2.x;

    p1.y ^= p2.y;
    p2.y ^= p1.y;
    p1.y ^= p2.y;
}
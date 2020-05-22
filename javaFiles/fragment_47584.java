@Override
public boolean equals(Object o) {
    System.out.println("equals Point");
    if (!(o instanceof Point))
        return false;
    Point p = (Point) o;
    return p.x == x && p.y == y;
}
@Override public boolean equals(Object compare) {
    if (compare == this) {
        return true;
    }
    if (compare == null || compare.getClass() != getClass()) {
        return false;
    }
    Point temp = (Point) compare; // Guaranteed to work now
    return temp.x == x && temp.y == y && temp.z == z;
}
@Override public boolean equals(Object o) {
    if (o == null) {
        return false;
    }
    if (o.getClass() != getClass()) {
        return false;
    }
    Coord other = (Coord) o;
    return other.r == r && other.c == c;
}
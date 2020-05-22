public interface Group implements Group {
    public Point[] getCoordinates();

    /*
     * Compares the specified object with this Group for equality. Returns true
     * if and only if the specified object is also a Group with exactly the same
     * coordinates
     */
    @Override public boolean equals(Object o);
}
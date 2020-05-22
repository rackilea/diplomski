// Note: final class, final member -- that makes this class immutable
final class C {
    private final int i;
    public C(int i) { this.i = i; }

    @Override
    public int hashCode() { return i; }
    @Override
    public boolean equals(Object o)
    {
        // no object equals null
        if (o == null)
            return false;
        // an object is always equal to itself
        if (this == o)
            return true;
        // immutable class: if the class of the other is not the same,
        // objects are not equal
        if (getClass() != o.getClass())
            return false;
        // Both objects are of the same class: check their members
        return i == ((C) o).i;
    }
}
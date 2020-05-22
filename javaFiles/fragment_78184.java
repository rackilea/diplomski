public class Coordinates {
    public final int row;
    public final int col;

    public Coordinates(int r, int c) {
        this.row = r;
        this.col = c;
    }

    @Override
    public int hashCode() {
        return (row + 37*col) & 0x7FFFFFFF;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != getClass()) {
            return false;
        }
        Coordinates o = (Coordinates)other;
        return row == o.row && col == o.col;
    }
}
public final class TablePos {

    private final int x;
    private final int y;

    public TablePos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.x;
        hash = 17 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TablePos)) {
            return false;
        }
        final TablePos other = (TablePos) obj;
        return (this.x == other.x && this.y == other.y);
    }

}
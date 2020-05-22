static class Coords {
    int x;
    int y;

    public boolean equals(Object o) {
        Coords c = (Coords) o;
        return c.x == x && c.y == y;
    }

    public Coords(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        return new Integer(x + "0" + y);
    }

    public String toString()
    {
        return x + ";" + y;
    }
}
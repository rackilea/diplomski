class Point {
    public final int x;
    public final int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // !!! OVERRIDE hashCode() and equals() so  you can use this properly in a HashMap !!!
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.x;
        hash = 71 * hash + this.y;
        return hash;
    }

     @Override
    public int equals(Object o) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (getClass() != o.getClass())
            return false;
        Point p = (Point) o;
        return this.x == p.x && this.y == p.y;
    }
}
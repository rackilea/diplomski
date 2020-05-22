class Point {

    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
         return x*31 + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Point) { 
           Point p = (Point) o;
           if (p.x == this.x && p.y == this.y) {
               return true;
           }
        }
        return false;
    }
    public int[] pos() {
        return new int[] {x, y};
    }

    public int[] reverse() {
        return new int[] {y, x};
    }

    @Override
    public String toString() { 
        return String.format(x + "," + y); 
    } 
}
public class Coord {

    public int x; 
    public int y;

    public Coord(int x, int y) { 
        this.x = x; 
        this.y = y; 
    }

    @Override
    public boolean equals(Object obj){

        if (obj == null)
            return false;
        if (obj.getClass() != Coord.class)
            return false;
        if (obj == this)
            return true;

        Coord a = (Coord)obj;
        return (a.x == this.x && a.y == this.y);
    }

    @Override
    public int hashCode() {
        return x*17 + y*31;
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
}
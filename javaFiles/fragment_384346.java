public class Cell implements Cloneable {

    int col;
    int row;
    boolean traversable;
    Type type;

    double g;
    double f;
    double h;

    Cell cameFrom;

    public Cell( int col, int row, boolean traversable) {
        this.col=col;
        this.row=row;
        this.traversable = traversable;
    }

    public double getF() {
        return f;
    }

    public double getG() {
        return g;
    }

    public double getH() {
        return h;
    }

    public void setTraversable( boolean traversable) {
        this.traversable = traversable;
    }

    public void setType( Type type) {
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    public String toString() {
        return col + "/" + row;
    }
}
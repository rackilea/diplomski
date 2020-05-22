public class Tile implements Cloneable {

    // other implementation

    public Tile clone() throws CloneNotSupportedException {
        return (Tile) super.clone();
    }
}
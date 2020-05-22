public class Foo implements Cloneable {
    public Foo clone() {
        try {
            return (Foo) super.clone();
        } catch (CloneNotSupportedException e) {
            return null; // can never happen!
    }
}
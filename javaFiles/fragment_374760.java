public abstract class AbstractFoo implements Cloneable {

    public abstract Object clone();

    // Enables subclasses to call "super.super.clone()"
    public Object superDotClone() throws CloneNotSupportedException {
        return super.clone();
    }

}
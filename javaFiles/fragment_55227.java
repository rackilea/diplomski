public class Relationship {

    private Paintable parent;
    private Paintable child;

    public Relationship(Paintable parent, Paintable child) {
        this.parent = parent;
        this.child = child;
    }

    public Paintable getChild() {
        return child;
    }

    public Paintable getParent() {
        return parent;
    }

}
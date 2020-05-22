public class Parent {
    private Child child;

    public void setChild(Child child) {
        this.child = child;
        this.child.setParent(this);
    }

    // ...
}
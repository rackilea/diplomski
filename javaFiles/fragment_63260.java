@JsonTypeName("listing")
public class Listing<T> {
    List<Thing<T>> children;

    public List<Thing<T>> getChildren() {
        return children;
    }

    public void setChildren(final List<Thing<T>> children) {
        this.children = children;
    }
}
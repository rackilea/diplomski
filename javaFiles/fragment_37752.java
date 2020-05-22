public class Foo<ParentType extends Parent<B>, B> {
    public ParentType parent;
    public B otherItem;

    public Foo(final ParentType parent, final B otherItem) {
        this.parent = parent;
        this.otherItem = otherItem;
        final B b = parent.b;
    }
}
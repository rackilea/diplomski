public class GenSet<E extends Foo> { // E has an upper bound of Foo

    private Foo[] a; // E erases to Foo, so use Foo[]

    public GenSet(int s) {
        a = new Foo[s];
    }

    ...
}
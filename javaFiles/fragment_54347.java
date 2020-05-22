public class Foo {

    private final int id;

    public Foo(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[id=" + id + "]";
    }
}
public class FooList<T> extends ArrayList<FooInterface<T>> {
    @Override
    public boolean add(FooInterface<T> e) {
        return super.add(e);
    }
    ...
}
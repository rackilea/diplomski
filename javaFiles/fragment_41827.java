public class DelegatingList<E> implements List<E> {
    private final List<E> list;
    protected DelegatingList(List<E> list) {
        this.list = list;
    }
    @Override
    public int size() {
        return this.list.size();
    }
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
    @Override
    public boolean contains(Object o) {
        return this.list.contains(o);
    }
    // many other delegating methods from List
}
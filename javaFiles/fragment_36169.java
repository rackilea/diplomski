public class BulkEditObservableList<T> extends ModifiableObservableListBase<T> {

    private final List<T> backingList;

    public BulkEditObservableList(List<T> backingList) {
        if (backingList == null) {
            throw new IllegalArgumentException();
        }
        this.backingList = backingList;
    }

    public BulkEditObservableList() {
        this(new ArrayList<>());
    }

    @Override
    public T get(int index) {
        return backingList.get(index);
    }

    @Override
    public int size() {
        return backingList.size();
    }

    @Override
    protected void doAdd(int index, T element) {
        backingList.add(index, element);

    }

    @Override
    protected T doSet(int index, T element) {
        return backingList.set(index, element);
    }

    @Override
    protected T doRemove(int index) {
        return backingList.remove(index);
    }

    public void beginBulkChange() {
        beginChange();
    }

    public void endBulkChange() {
        endChange();
    }

}
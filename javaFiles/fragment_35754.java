public class ListBasedListModel<T> extends AbstractListModel<T> {

    private List<T> data;

    public ListBasedListModel(List<T> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public T getElementAt(int index) {
        return data.get(index);
    }
}
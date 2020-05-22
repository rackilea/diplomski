private SortedListModel<String> destListModel = new SortedListModel<>();
…
class SortedListModel<E> extends AbstractListModel<E> {

    private final SortedSet<E> model;

    public SortedListModel() {
        model = new TreeSet<>();
    }

    public List<E> toList() {
        return new ArrayList<>(model);
    }

    @Override
    public E getElementAt(int index) {
        return (E) model.toArray()[index];
    }

    public void add(E element) {
        if (model.add(element)) {
            fireContentsChanged(this, 0, getSize());
        }
    }
    …
}
…
System.out.println(destListModel.toList());
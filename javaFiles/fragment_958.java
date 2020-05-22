/**
 * Sorts the provided observable list.
 * Fires only <b>one</b> change notification on the list.
 * @see Collections#sort(java.util.List)
 */
@SuppressWarnings("unchecked")
public static <T extends Comparable<? super T>> void sort(ObservableList<T> list) {
    if (list instanceof SortableList) {
        ((SortableList<? extends T>)list).sort(); // here's what happens
    } else {
        List<T> newContent = new ArrayList<T>(list);
        Collections.sort(newContent);
        list.setAll((Collection<T>)newContent);
    }
}
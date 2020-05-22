/**
 * Notify registered callbacks that some elements have changed.
 *
 * @param list The list that changed.
 * @param start The index of the first changed element.
 * @param count The number of changed elements.
 */
public void notifyChanged(ObservableList list, int start, int count) {
    ListChanges listChanges = acquire(start, 0, count);
    notifyCallbacks(list, CHANGED, listChanges);
}
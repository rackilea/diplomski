@Override
public void sort(Comparator<? super E> comparator) {
    if (backingList.isEmpty()) {
        return;
    }
    int[] perm = getSortHelper().sort(backingList, comparator);
    // here's the single change fired
    fireChange(new SimplePermutationChange<E>(0, size(), perm, this));
}
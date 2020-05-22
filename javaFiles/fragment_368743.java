public static <T extends Comparable<? super T>> void compareSortedLists(
        Iterable<T> list1, Iterable<T> list2,
        Collection<T> onlyInList1, Collection<T> onlyInList2) {
    PeekingIterator<T> it1 = new PeekingIterator<>(list1.iterator());
    PeekingIterator<T> it2 = new PeekingIterator<>(list2.iterator());
    while (it1.hasNext() && it2.hasNext()) {
        int comp = it1.peek().compareTo(it2.peek());
        if (comp < 0)
            onlyInList1.add(it1.next());
        else if (comp > 0)
            onlyInList2.add(it2.next());
        else /* comp == 0 */ {
            it1.next();
            it2.next();
        }
    }
    it1.forEachRemaining(onlyInList1::add);
    it2.forEachRemaining(onlyInList2::add);
}
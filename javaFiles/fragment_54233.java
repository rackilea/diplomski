public class Example {
    List<List<String>> lists;
    ListIterator<List<String>> curListsIter;
    ListIterator<String> curStringIter;

    @Override
    public String next() {
        return get(ListIterator::hasNext, ListIterator::next, List::listIterator);
    }

    @Override
    public String previous() {
        return get(ListIterator::hasPrevious, ListIterator::previous, Example::atEnd);
    }

    private static <T> ListIterator<T> atEnd(List<T> list) {
        return list.listIterator(list.size());
    }

    interface IterFunction {
        <T> T apply(ListIterator<T> t);
    }
    interface GetIterFunction {
        <T> ListIterator<T> apply(List<T> t);
    }
    private String get(Predicate<ListIterator<?>> has,
                       IterFunction item, GetIterFunction getIter) {
        if(curListsIter == null) curListsIter = getIter.apply(lists);
        while(curStringIter == null || !has.test(curStringIter)) {
            // may throw NoSuchElementException
            curStringIter = getIter.apply(item.apply(curListsIter));
        }
        return item.apply(curStringIter);
    }
}
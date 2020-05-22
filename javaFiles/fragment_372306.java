class IndexedMultiset<T extends Comparable<T>> extends ForwardingMultiset<T> {

    private final Multiset<T> delegate = HashMultiset.create();
    private final TreeMultimap<Integer, T> countIndex = TreeMultimap.create();

    @Override
    protected Multiset<T> delegate() {
        return delegate;
    }


    @Override
    public int add(T element, int occurrences) {
        int prev = super.add(element, occurrences);
        countIndex.remove(prev, element);
        countIndex.put(count(element), element);
        return prev;
    }

    @Override
    public boolean add(T element) {
        return super.standardAdd(element);
    }

    //similar for remove, setCount, etc


}
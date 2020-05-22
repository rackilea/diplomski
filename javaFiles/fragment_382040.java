class Folding<T,G> implements Spliterator<Map.Entry<G,List<T>>> {
    static <T,G> Stream<Map.Entry<G,List<T>>> foldBy(
            Stream<? extends T> s, Function<? super T, ? extends G> f) {
        return StreamSupport.stream(new Folding<>(s.spliterator(), f), false);
    }
    private final Spliterator<? extends T> source;
    private final Function<? super T, ? extends G> pf;
    private final Consumer<T> c=this::addItem;
    private List<T> pending, result;
    private G pendingGroup, resultGroup;

    Folding(Spliterator<? extends T> s, Function<? super T, ? extends G> f) {
        source=s;
        pf=f;
    }
    private void addItem(T item) {
        G group=pf.apply(item);
        if(pending==null) pending=new ArrayList<>();
        else if(!pending.isEmpty()) {
            if(!Objects.equals(group, pendingGroup)) {
                if(pending.size()==1)
                    result=Collections.singletonList(pending.remove(0));
                else {
                    result=pending;
                    pending=new ArrayList<>();
                }
                resultGroup=pendingGroup;
            }
        }
        pendingGroup=group;
        pending.add(item);
    }
    public boolean tryAdvance(Consumer<? super Map.Entry<G, List<T>>> action) {
        while(source.tryAdvance(c)) {
            if(result!=null) {
                action.accept(entry(resultGroup, result));
                result=null;
                return true;
            }
        }
        if(pending!=null) {
            action.accept(entry(pendingGroup, pending));
            pending=null;
            return true;
        }
        return false;
    }
    private Map.Entry<G,List<T>> entry(G g, List<T> l) {
        return new AbstractMap.SimpleImmutableEntry<>(g, l);
    }
    public int characteristics() { return 0; }
    public long estimateSize() { return Long.MAX_VALUE; }
    public Spliterator<Map.Entry<G, List<T>>> trySplit() { return null; }
}
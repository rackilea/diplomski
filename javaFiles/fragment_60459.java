class Wrapper<T> implements Spliterator<T> {
    final Spliterator<T> source;
    public Wrapper(Spliterator<T> source) {
        this.source = source;
    }
    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        try {
            return source.tryAdvance(action);
        }
        catch(XmlParseException ex) {
            throw new CustomRuntimeException(ex);
        }
    }
    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        try {
            source.forEachRemaining(action);
        }
        catch(XmlParseException ex) {
            throw new CustomRuntimeException(ex);
        }
    }
    @Override public Spliterator<T> trySplit() {
        Spliterator<T> srcPrefix = source.trySplit();
        return srcPrefix == null? null: new Wrapper<>(srcPrefix);
    }
    @Override public long estimateSize() { return source.estimateSize(); }
    @Override public int characteristics() { return source.characteristics(); }
    @Override public Comparator<? super T> getComparator(){return source.getComparator();}
}
public static <T> Stream<List<T>> chunked(Stream<T> s, int chunkSize) {
    if(chunkSize<1) throw new IllegalArgumentException("chunkSize=="+chunkSize);
    if(chunkSize==1) return s.map(Collections::singletonList);
    Spliterator<T> src=s.spliterator();
    long size=src.estimateSize();
    if(size!=Long.MAX_VALUE) size=(size+chunkSize-1)/chunkSize;
    int ch=src.characteristics();
    ch&=Spliterator.SIZED|Spliterator.ORDERED|Spliterator.DISTINCT|Spliterator.IMMUTABLE;
    ch|=Spliterator.NONNULL;
    return StreamSupport.stream(new Spliterators.AbstractSpliterator<List<T>>(size, ch)
    {
        private List<T> current;
        @Override
        public boolean tryAdvance(Consumer<? super List<T>> action) {
            if(current==null) current=new ArrayList<>(chunkSize);
            while(current.size()<chunkSize && src.tryAdvance(current::add));
            if(!current.isEmpty()) {
                action.accept(current);
                current=null;
                return true;
            }
            return false;
        }
    }, s.isParallel());
}
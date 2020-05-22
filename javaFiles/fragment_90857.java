public class FlatMappingSpliterator<E,S> extends Spliterators.AbstractSpliterator<E>
implements Consumer<S> {

    static final boolean USE_ORIGINAL_IMPL
        = Boolean.getBoolean("stream.flatmap.usestandard");

    public static <T,R> Stream<R> flatMap(
        Stream<T> in, Function<? super T,? extends Stream<? extends R>> mapper) {

        if(USE_ORIGINAL_IMPL)
            return in.flatMap(mapper);

        Objects.requireNonNull(in);
        Objects.requireNonNull(mapper);
        return StreamSupport.stream(
            new FlatMappingSpliterator<>(sp(in), mapper), in.isParallel()
        ).onClose(in::close);
    }

    final Spliterator<S> src;
    final Function<? super S, ? extends Stream<? extends E>> f;
    Stream<? extends E> currStream;
    Spliterator<E> curr;

    private FlatMappingSpliterator(
        Spliterator<S> src, Function<? super S, ? extends Stream<? extends E>> f) {
        // actually, the mapping function can change the size to anything,
        // but it seems, with the current stream implementation, we are
        // better off with an estimate being wrong by magnitudes than with
        // reporting unknown size
        super(src.estimateSize()+100, src.characteristics()&ORDERED);
        this.src = src;
        this.f = f;
    }

    private void closeCurr() {
        try { currStream.close(); } finally { currStream=null; curr=null; }
    }

    public void accept(S s) {
        curr=sp(currStream=f.apply(s));
    }

    @Override
    public boolean tryAdvance(Consumer<? super E> action) {
        do {
            if(curr!=null) {
                if(curr.tryAdvance(action))
                    return true;
                closeCurr();
            }
        } while(src.tryAdvance(this));
        return false;
    }

    @Override
    public void forEachRemaining(Consumer<? super E> action) {
        if(curr!=null) {
            curr.forEachRemaining(action);
            closeCurr();
        }
        src.forEachRemaining(s->{
            try(Stream<? extends E> str=f.apply(s)) {
                if(str!=null) str.spliterator().forEachRemaining(action);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private static <X> Spliterator<X> sp(Stream<? extends X> str) {
        return str!=null? ((Stream<X>)str).spliterator(): null;
    }

    @Override
    public Spliterator<E> trySplit() {
        Spliterator<S> split = src.trySplit();
        if(split==null) {
            Spliterator<E> prefix = curr;
            while(prefix==null && src.tryAdvance(s->curr=sp(f.apply(s))))
                prefix=curr;
            curr=null;
            return prefix;
        }
        FlatMappingSpliterator<E,S> prefix=new FlatMappingSpliterator<>(split, f);
        if(curr!=null) {
            prefix.curr=curr;
            curr=null;
        }
        return prefix;
    }
}
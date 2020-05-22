public class PagingSpliterator<T> implements Spliterator<T> {
    public interface PageFetcher<T> {
        List<T> fetchPage(long offset, long limit, LongConsumer totalSizeSink);
    }
    public static final long DEFAULT_PAGE_SIZE = 100;

    public static <T> Stream<T> paged(PageFetcher<T> pageAccessor) {
        return paged(pageAccessor, DEFAULT_PAGE_SIZE, false);
    }
    public static <T> Stream<T> paged(PageFetcher<T> pageAccessor,
                                      long pageSize, boolean parallel) {
        if(pageSize<=0) throw new IllegalArgumentException();
        return StreamSupport.stream(() -> {
            PagingSpliterator<T> pgSp
                = new PagingSpliterator<>(pageAccessor, 0, 0, pageSize);
            pgSp.danglingFirstPage
                =spliterator(pageAccessor.fetchPage(0, pageSize, l -> pgSp.end=l));
            return pgSp;
        }, CHARACTERISTICS, parallel);
    }
    private static final int CHARACTERISTICS = IMMUTABLE|ORDERED|SIZED|SUBSIZED;

    private final PageFetcher<T> supplier;
    long start, end, pageSize;
    Spliterator<T> currentPage, danglingFirstPage;

    PagingSpliterator(PageFetcher<T> supplier,
            long start, long end, long pageSize) {
        this.supplier = supplier;
        this.start    = start;
        this.end      = end;
        this.pageSize = pageSize;
    }

    public boolean tryAdvance(Consumer<? super T> action) {
        for(;;) {
            if(ensurePage().tryAdvance(action)) return true;
            if(start>=end) return false;
            currentPage=null;
        }
    }
    public void forEachRemaining(Consumer<? super T> action) {
        do {
            ensurePage().forEachRemaining(action);
            currentPage=null;
        } while(start<end);
    }
    public Spliterator<T> trySplit() {
        if(danglingFirstPage!=null) {
            Spliterator<T> fp=danglingFirstPage;
            danglingFirstPage=null;
            start=fp.getExactSizeIfKnown();
            return fp;
        }
        if(currentPage!=null)
            return currentPage.trySplit();
        if(end-start>pageSize) {
            long mid=(start+end)>>>1;
            mid=mid/pageSize*pageSize;
            if(mid==start) mid+=pageSize;
            return new PagingSpliterator<>(supplier, start, start=mid, pageSize);
        }
        return ensurePage().trySplit();
    }
    /**
     * Fetch data immediately before traversing or sub-page splitting.
     */
    private Spliterator<T> ensurePage() {
        if(danglingFirstPage!=null) {
            Spliterator<T> fp=danglingFirstPage;
            danglingFirstPage=null;
            currentPage=fp;
            start=fp.getExactSizeIfKnown();
            return fp;
        }
        Spliterator<T> sp = currentPage;
        if(sp==null) {
            if(start>=end) return Spliterators.emptySpliterator();
            sp = spliterator(supplier.fetchPage(
                                 start, Math.min(end-start, pageSize), l->{}));
            start += sp.getExactSizeIfKnown();
            currentPage=sp;
        }
        return sp;
    }
    /**
     * Ensure that the sub-spliterator provided by the List is compatible with
     * ours, i.e. is {@code SIZED | SUBSIZED}. For standard List implementations,
     * the spliterators are, so the costs of dumping into an intermediate array
     * in the other case is irrelevant.
     */
    private static <E> Spliterator<E> spliterator(List<E> list) {
        Spliterator<E> sp = list.spliterator();
        if((sp.characteristics()&(SIZED|SUBSIZED))!=(SIZED|SUBSIZED))
            sp=Spliterators.spliterator(
                StreamSupport.stream(sp, false).toArray(), IMMUTABLE | ORDERED);
        return sp;
    }
    public long estimateSize() {
        if(currentPage!=null) return currentPage.estimateSize();
        return end-start;
    }
    public int characteristics() {
        return CHARACTERISTICS;
    }
}
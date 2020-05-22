public static long count(BaseStream<?,?> s) {
    Spliterator<?> sp = s.spliterator();
    long c = sp.getExactSizeIfKnown();
    if(c >= 0) return c;
    final class Counter implements Consumer<Object>,
        IntConsumer, LongConsumer, DoubleConsumer { // avoid boxing where possible
        long count;
        public void accept(Object t) { count++; }
        public void accept(int value) { count++; }
        public void accept(long value) { count++; }
        public void accept(double value) { count++; }
    }
    Counter c = new Counter();
    sp.forEachRemaining(c);
    return c.count;
}
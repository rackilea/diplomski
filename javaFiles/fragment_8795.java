static <T> void foo3(Collection<? extends T> collection, ToIntFunction<? super T> function) {
    class Pair {
        int max = Integer.MIN_VALUE;
        T maxT = null;
    }
    T maxT = collection.stream().collect(Collector.of(
        Pair::new,
        (p, t) -> {
            int result = function.applyAsInt(t);
            if (result >= p.max) {
                p.max = result;
                p.maxT = t;
            }
        }, 
        (p1, p2) -> p2.max > p1.max ? p2 : p1,
        p -> p.maxT
    ));
    // do something with maxT
}
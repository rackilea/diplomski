public class Reducer {
    public static <A> Collector<A, ?, A> reduce(Function<A, A> initializer, 
                                                BiConsumer<A, A> combiner) {
        return Collectors.reducing(null, (fst, snd) -> Optional.ofNullable(fst)
            .map(cur -> { combiner.accept(cur, snd); return cur; })
            .orElseGet(() -> initializer.apply(snd)));
    }
    public static <A> Collector<A, ?, A> reduce(Supplier<A> supplier, 
                                                BiConsumer<A, A> combiner) {
        return reduce((ign) -> supplier.get(), combiner);
    }
}
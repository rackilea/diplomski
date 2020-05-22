public static <T, K> Collector<T, ?, Map<K, Long>> groupsWithTotal(
    Function<? super T, ? extends K> classifier,
    K totalKeyName) {

    class Acc {
        Map<K, Long> map = new LinkedHashMap<>();
        long total = 0L;

        void accumulate(T elem) {
            this.map.merge(classifier.apply(elem), 1L, Long::sum);
            this.total++;
        }

        Acc combine(Acc another) {
            another.map.forEach((k, v) -> {
                this.map.merge(k, v, Long::sum);
                this.total += v;
            });
            return this;
        }

        Map<K, Long> finish() {
            this.map.put(totalKeyName, total);
            return this.map;
        }
    }

    return Collector.of(Acc::new, Acc::accumulate, Acc::combine, Acc::finish);
}
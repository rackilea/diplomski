static <T> Collector<T,PriorityQueue<T>,List<T>> topK(int k, Comparator<? super T> comp) {
    return Collector.of(
        () -> new PriorityQueue<>(k+1, comp),
        (pq, t) -> {
            pq.add(t);
            if (pq.size() > k)
                pq.poll();
        },
        (pq1, pq2) -> {
            pq1.addAll(pq2);
            while (pq1.size() > k)
                pq1.poll();
            return pq1;
        },
        pq -> {
            int n = pq.size();
            @SuppressWarnings("unchecked")
            T[] a = (T[])new Object[n];
            while (--n >= 0)
                a[n] = pq.poll();
            return Arrays.asList(a);
        },
        Collector.Characteristics.UNORDERED);
}
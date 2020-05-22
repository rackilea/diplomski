@Benchmark
public void testSequentialFor(Blackhole bh, Words words) {
    List<String> filtered = new ArrayList<>();
    for (String word : words.toSort) {
        if (word.startsWith(words.prefix)) {
            filtered.add(word);
        }
    }
    bh.consume(filtered);
}

@Benchmark
public void testParallelStream(Blackhole bh, Words words) {
    bh.consume(words.toSort.parallelStream()
            .filter(w -> w.startsWith(words.prefix))
            .collect(Collectors.toList())
    );
}

@Benchmark
public void testManualThreading(Blackhole bh, Words words) {
    // This is quick and dirty, bit gives a decent baseline as to
    // what a manually threaded partitionning can achieve.
    List<Future<List<String>>> async = new ArrayList<>();
    // this has to be optimized to avoid creating "almost empty" work units
    int batchSize = words.size / ForkJoinPool.commonPool().getParallelism();
    int numberOfDispatchedWords = 0;
    while (numberOfDispatchedWords < words.toSort.size()) {
        int start = numberOfDispatchedWords;
        int end = numberOfDispatchedWords + batchSize;
        async.add(words.threadPool.submit(() -> {
            List<String> batch = words.toSort.subList(start, Math.min(end, words.toSort.size()));
            List<String> result = new ArrayList<>();
            for (String word : batch) {
                if (word.startsWith(words.prefix)) {
                    result.add(word);
                }
            }
            return result;
        }));
        numberOfDispatchedWords += batchSize;
    }
    List<String> result = new ArrayList<>();
    for (Future<List<String>> asyncResult : async) {
        try {
            result.addAll(asyncResult.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    bh.consume(result);
}

@State(Scope.Benchmark)
public static class Words {

    ExecutorService threadPool = ForkJoinPool.commonPool();

    List<String> toSort;

    @Param({"100", "1000", "10000", "100000"})
    private int size;

    private String prefix = "AA";

    @Setup
    public void prepare() {
        //a 4 to 13 letters long, random word
        //for more precision, it should not be that random (use a fixed seed), but given the simple nature of the fitlering, I guess it's ok this way
        Supplier<String> wordCreator = () -> RandomStringUtils.random(4 + ThreadLocalRandom.current().nextInt(10));
        toSort = Stream.generate(wordCreator).limit(size).collect(Collectors.toList());
    }
}
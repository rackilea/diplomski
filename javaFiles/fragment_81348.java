public class PipelineOfTasksExample {
    private final Map<Long, String> db = LongStream.rangeClosed(1, 4).boxed()
        .collect(Collectors.toMap(id -> id, id -> "user"+id));

    PipelineOfTasksExample() {}

    private static <T> T slowDown(String op, T result) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(500));
        System.out.println(op + " -> " + result + " thread: "
            + Thread.currentThread().getName()+ ", "
            + POOL.getPoolSize() + " threads");
        return result;
    }
    private CompletableFuture<List<Long>> returnUserIdsFromDb() {
        System.out.println("trigger building the list of Ids - thread: "
            + Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(
            () -> slowDown("building the list of Ids", Arrays.asList(1L, 2L, 3L, 4L)),
            POOL);
    }
    private CompletableFuture<String> fetchById(Long id) {
        System.out.println("trigger fetching id: " + id + " thread: "
            + Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(
            () -> slowDown("fetching id: " + id , db.get(id)), POOL);
    }

    static ForkJoinPool POOL = new ForkJoinPool(2);

    public static void main(String[] args) {
        PipelineOfTasksExample example = new PipelineOfTasksExample();

        CompletableFuture<List<String>> result = example.returnUserIdsFromDb()
            .thenComposeAsync(listOfIds -> {
                List<CompletableFuture<String>> jobs = listOfIds.parallelStream()
                    .map(id -> example.fetchById(id))
                    .collect(Collectors.toList());
                return CompletableFuture.allOf(jobs.toArray(new CompletableFuture<?>[0]))
                    .thenApply(_void -> jobs.stream()
                        .map(CompletableFuture::join).collect(Collectors.toList()));
                },
                POOL
            );

        System.out.println(result.join());
        System.out.println(ForkJoinPool.commonPool().getPoolSize());
    }
}
public class JobITCase {

    private static final int NUM_TMS = 2;
    private static final int NUM_SLOTS = 2;
    private static final int PARALLELISM = NUM_SLOTS * NUM_TMS;

    @ClassRule
    public final static MiniClusterWithClientResource MINI_CLUSTER_WITH_CLIENT_RESOURCE = new MiniClusterWithClientResource(
            new MiniClusterResourceConfiguration.Builder()
                .setNumberSlotsPerTaskManager(NUM_SLOTS)
                .setNumberTaskManagers(NUM_TMS)
                .build());

    @Test
    public void testJob() throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(PARALLELISM);

        final MyControllableSourceFunction source1 = new MyControllableSourceFunction("source1");
        final MyControllableSourceFunction source2 = new MyControllableSourceFunction("source2");

        final DataStreamSource<Integer> input1 = env.addSource(source1);
        final DataStreamSource<Integer> input2 = env.addSource(source2);

        input1.connect(input2).map(new CoMapFunction<Integer, Integer, Integer>() {
            @Override
            public Integer map1(Integer integer) {
                System.out.println("Input 1: " + integer);
                return integer;
            }

            @Override
            public Integer map2(Integer integer) {
                System.out.println("Input 2: " + integer);
                return integer;
            }
        }).print();

        final JobGraph jobGraph = env.getStreamGraph().getJobGraph();

        MINI_CLUSTER_WITH_CLIENT_RESOURCE.getMiniCluster().submitJob(jobGraph).get();

        final CompletableFuture<JobResult> jobResultFuture = MINI_CLUSTER_WITH_CLIENT_RESOURCE.getMiniCluster().requestJobResult(jobGraph.getJobID());

        final ArrayList<CompletableFuture<Void>> finishedFutures = new ArrayList<>(PARALLELISM);

        for (int i = 0; i < PARALLELISM; i++) {
            MyControllableSourceFunction.startExecution(source1, i);
            finishedFutures.add(MyControllableSourceFunction.getFinishedFuture(source1, i));
        }

        FutureUtils.waitForAll(finishedFutures).join();

        for (int i = 0; i < PARALLELISM; i++) {
            MyControllableSourceFunction.startExecution(source2, i);
        }

        jobResultFuture.join();
    }

    private static class MyControllableSourceFunction extends RichParallelSourceFunction<Integer> {

        private static final ConcurrentMap<String, CountDownLatch> startLatches = new ConcurrentHashMap<>();
        private static final ConcurrentMap<String, CompletableFuture<Void>> finishedFutures = new ConcurrentHashMap<>();

        private final String name;

        private boolean running = true;

        private MyControllableSourceFunction(String name) {
            this.name = name;
        }

        @Override
        public void run(SourceContext<Integer> sourceContext) throws Exception {
            final int index = getRuntimeContext().getIndexOfThisSubtask();

            final CountDownLatch startLatch = startLatches.computeIfAbsent(getId(index), ignored -> new CountDownLatch(1));
            final CompletableFuture<Void> finishedFuture = finishedFutures.computeIfAbsent(getId(index), ignored -> new CompletableFuture<>());

            startLatch.await();
            int counter = 0;

            while (running && counter < 10) {
                synchronized (sourceContext.getCheckpointLock()) {
                    sourceContext.collect(counter++);
                }
            }

            finishedFuture.complete(null);
        }

        @Override
        public void cancel() {
            running = false;
        }

        private String getId(int index) {
            return name + '_' + index;
        }

        static void startExecution(MyControllableSourceFunction source, int index) {
            final CountDownLatch startLatch = startLatches.computeIfAbsent(source.getId(index), ignored -> new CountDownLatch(1));
            startLatch.countDown();
        }

        static CompletableFuture<Void> getFinishedFuture(MyControllableSourceFunction source, int index) {
            return finishedFutures.computeIfAbsent(source.getId(index), ignored -> new CompletableFuture<>());
        }
    }
}
class ThreadTask implements Runnable {
    private int id;
    public static ConcurrentHashMap<Long, AtomicLong> selectHistogram = new ConcurrentHashMap<Long, AtomicLong>();

    private List<FutureTask<Long>> taskList;    

    public ThreadTask(int id, List<FutureTask<Long>> taskList) {
        this.id = id;
        this.taskList = taskList;
    }

    @Override
    public void run() {


        long start = System.nanoTime();

        attributes = beClient.getAttributes(columnsList);

        long end = System.nanoTime() - start;

        final AtomicLong before = selectHistogram.putIfAbsent(end / 1000000L, new AtomicLong(1L));
        if (before != null) {
            FutureTask<Long> futureTask = new FutureTask<Long>(new Callable<Long>() {
                public Long call() {
                    return before.incrementAndGet();
                }
            });
            taskList.add(futureTask);
        }
    }
}
public class MyThread extends ForkJoinWorkerThread {
    public MyThread(ForkJoinPool pool, int priority) {
        super(pool);
        setPriority(priority);
    }
}

final int poolSize = ...
final int priority = ...

List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed()
  .collect(Collectors.toList());

ForkJoinWorkerThreadFactory factory = new ForkJoinWorkerThreadFactory() {
    public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
         return new MyThread(pool, priority);
    }
};
/*
ForkJoinWorkerThreadFactory factory = pool -> new MyThread(
  pool,
  priority
);
*/

ForkJoinPool customThreadPool = new ForkJoinPool(
    poolSize, factory, null, false);
long actualTotal = customThreadPool.submit(
    () -> aList.parallelStream().reduce(0L, Long::sum)).get();
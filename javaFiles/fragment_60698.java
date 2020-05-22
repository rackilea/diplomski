Import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class OrderedResultsExecutors extends ThreadPoolExecutor {
    public OrderedResultsExecutors(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    private ConcurrentHashMap<Long, Runnable> startedTasks = new ConcurrentHashMap<>();
    private ConcurrentLinkedDeque<Runnable> finishedTasks = new ConcurrentLinkedDeque<>();
    private AtomicLong toNotify = new AtomicLong(0);
    private AtomicLong submitedCount = new AtomicLong(0);

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        startedTasks.put(submitedCount.getAndIncrement(), r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        finishedTasks.add(r);
        finishedTask();
    }

    private void finishedTask() {
        Runnable orderedResult;
        long current;
        while ((orderedResult = startedTasks.get(current = toNotify.get())) != null
                && finishedTasks.contains(orderedResult) && (orderedResult = startedTasks.remove(current)) != null) {
            finishedTasks.remove(orderedResult);
            notify(current, orderedResult);
            toNotify.incrementAndGet();
        }
    }

    private void notify(long order, Runnable result) {
        try {
            System.out.println("order: " + order + " result: " + ((Future)result).get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static ExecutorService newFixedThreadPool(int noOfThreads) {
        int corePoolSize = noOfThreads;
        int maximumPoolSize = noOfThreads;
        return new OrderedResultsExecutors(corePoolSize, maximumPoolSize, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

}
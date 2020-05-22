public class StusMagicExecutor extends ThreadPoolExecutor {
    private BlockingQueue<Runnable> secondaryQueue = new LinkedBlockingQueue<Runnable>();  //capacity is Integer.MAX_VALUE.

    public StusMagicExecutor() {
        super(5, 20, 60L, SECONDS, new SynchronousQueue<Runnable>(true), new RejectionHandler());  
    }
    public void queueRejectedTask(Runnable task) {
        try {
            secondaryQueue.put(task);
        } catch (InterruptedException e) {
            // do something
        }
    }
    public Future submit(Runnable newTask) {
        //drain secondary queue as rejection handler populates it
        Collection<Runnable> tasks = new ArrayList<Runnable>();
        secondaryQueue.drainTo(tasks);

        tasks.add(newTask);

        for (Runnable task : tasks)
             super.submit(task);

        return null; //does not return a future!
    }
}

class RejectionHandler implements RejectedExecutionHandler {
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        ((StusMagicExecutor)executor).queueRejectedTask(runnable);
    }
}
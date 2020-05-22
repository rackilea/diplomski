enum TaskState {PENDING, RUNNING};

abstract class MyCallable<V> implements Callable<V>{
    protected volatile TaskState state = PENDING;

    // to make sure state is always set before running the task
    protected abstract V doCall();

    final V call(){
        state = RUNNING;
        return doCall();
    }

    public TaskState getState() { return state; }
}

...

ExecutorService executor = Executors.newFixedThreadPool(4);

Future<V> future = executor.submit(new MyCallable<V>() {
    public V doCall() throws Exception {
        //... some work ...
        if(Thread.interrupted()){
            removeFromMap();
            return null;
        }
    }
});

...

future.cancel(true);
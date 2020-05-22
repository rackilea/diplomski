class Job implements Runnable {
    protected int count;
    private final ExecutorService executor;

    public Job(ExecutorService executor){
        this.count = 0;
        this.executor = executor;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());

        this.count = this.count + 1;
        System.out.print("");

        executor.execute(this);
    }
}
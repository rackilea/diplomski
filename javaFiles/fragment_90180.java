class Task implements Callable<Object> {

    private Image job;

    public Task(Image job) {
       this.job = job;
    }

    public Object call() {
        // crawl
        return result;
    }
}
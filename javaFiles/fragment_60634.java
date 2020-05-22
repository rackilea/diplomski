ExecutorService executor = Executors.newCachedThreadPool(); //or whatever you think is best, read the Javadocs for the different options under Executors
executor.execute(new Runnable() {
    @Override
    public void run() {
        //implement long running task here
    }
});
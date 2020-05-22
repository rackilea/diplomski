class DataProcessor implements Runnable {
    private final ExecutorService executor = 
        Executors.newSingleThreadedExecutor();

    public void stop { executor.shutdown(); }

    public void process(final Data data){
        executor.execute(new Runnable(){
            public void run(){
                // process data
            }
        });
    }

}
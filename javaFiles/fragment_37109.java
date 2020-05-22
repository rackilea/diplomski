final int numThreads = 8 ;
Executor exec = Executors.newFixedThreadPool(numThreads, runnable -> {
    Thread t = Executors.defaultThreadFactory().newThread(runnable);
    t.setDaemon(true);
    return t ;
});

// ...

for (int i = 1; i <= 300; i++) {
    int value = i ;
    Task<String> task = new Task<String>() {
        @Override
        public String call() {
            // in real life, do real work here...
            return "\n" + value ; // value to be processed in onSucceeded
        }
    };
    task.setOnSucceeded(e -> ta_Statusbereich.appendText(task.getValue()));
    exec.execute(task);
}
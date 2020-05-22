private ExecutorService ex = Executors.newSingleThreadExecutor();

public void yourMethod() {
    ex.submit(new Runnable() {
        public void run() {
            // Your logic
        }
    });
}
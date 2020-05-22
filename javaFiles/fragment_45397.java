public static void main(final String[] args) {
    int numberOfSimultaneousExecutions = 25;
    java.util.concurrent.Executor executor = java.util.concurrent.Executors.newFixedThreadPool(numberOfSimultaneousExecutions);
    for (int i = 0; i < numberOfSimultaneousExecutions; i++) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                RealMainClass.main(args);
            }
        });
    }
}
Runtime runtime = Runtime.getRuntime();
runtime.addShutdownHook(new Thread() {
    @Override
    public void run() {
        // save state before exiting and start again
        System.out.println("saving...");
    }
});
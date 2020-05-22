class Producer implements Callable<Void> {

    private final BlockingQueue<Path> changedFiles;

    Producer(BlockingQueue<Path> changedFiles) {
        this.changedFiles = changedFiles;
    }

    @Override
    public Void call() throws Exception {
        while (true) {
            if (something) {
                changedFiles.add(changedFile);
            }
            //to make the thread "interruptable"
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            } catch (InterruptedException ex) {
                break;
            }
        }
        return null;
    }
}
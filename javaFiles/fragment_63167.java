class Consumer implements Callable<Void> {

    private final BlockingQueue<Path> changedFiles;

    Consumer(BlockingQueue<Path> changedFiles) {
        this.changedFiles = changedFiles;
    }

    @Override
    public Void call() throws Exception {
        while (true) {
            try {
                final Path changedFile = changedFiles.take();
                //process your file
            //to make the thread "interruptable"
            } catch (InterruptedException ex) {
                break;
            }
        }
        return null;
    }
}
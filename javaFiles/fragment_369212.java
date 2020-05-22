public class WatcherService implements Callable<Object> {

    private Path path;
    private ExecutorService service;

    public WatcherService(Path path, ExecutorService service) {
        this.path = path;
        this.service = service;
    }

    @Override
    public Object call() throws Exception {
        do {
            try {
                WatchService watcher = path.getFileSystem().newWatchService();
                path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

                WatchKey watckKey = watcher.take();

                List<WatchEvent<?>> events = watckKey.pollEvents();
                for (@SuppressWarnings("rawtypes") WatchEvent event : events) {
                    WatchEvent<Path> we = (WatchEvent<Path>)event;
                    service.submit(new FileTask(we.context()));
                }
            } catch (IOException | InterruptedException exp) {
                exp.printStackTrace();
            }
        } while (true && !Thread.currentThread().isInterrupted());
        return null;
    }

}
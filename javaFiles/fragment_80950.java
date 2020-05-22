public class WatchServiceRunnableWrapper implements Runnable {

    private WatchService WatchService;

    public WatchServiceRunnableWrapper(WatchService watchService) {
        this.watchService = watchService;
    }

    public void run() {
        watchService.poll();
        //
    }
}
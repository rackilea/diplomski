public class MyTask extends TimerTask {
    private final AtomicBoolean shouldReload = new AtomicBoolean(false);

    public synchronized void reload() {
        this.shouldReload.set(true);
    }

    @Override
    public void run() {
        if(shouldReload.getAndSet(false)) {
            wv.getEngine().load("http://www.google.com");
            update();
        }
    }
}
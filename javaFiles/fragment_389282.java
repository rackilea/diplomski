public class MultithreadingInUnitTest {
    private Watcher watcher = new DefaultWatcher();

    public void runZipper() {
        exThread czct = new exThread();
        watcher.process(WatchedEvent.EVENT_1);
        czct.start();
    }

    private class exThread extends Thread {
        public void run() {
            try {
                //some business logic which generates a zipfile
            } catch (Exception e) {
            } finally {
                watcher.process(WatchedEvent.EVENT_2);
            }
        }
    }


    public void setWatcher(Watcher watcher) {
        this.watcher = watcher;
    }

    private class DefaultWatcher implements Watcher {
        @Override
        public void process(WatchedEvent event) {
            //Noop for production use
        }
    }
}

interface Watcher {
    public void process(WatchedEvent event);
}

enum WatchedEvent {
    EVENT_1, EVENT_2
}
public class MyThread extends Thread {
    private final InputStream processStream;
    private final Executor executor = Executors.newSingleThreadExecutor();

    public MyThread(InputStream processStream) {
        this.processStream = processStream;
    }

    @Override
    public void run() {
        while ([processStream has stuff]) {
            final Object obj = // Get your object from the stream
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // Do database stuff with obj
                }
            });
        }
    }

    private static Object getSomethingFromStream(InputStream stream) {
        // return something off the stream
    }
}
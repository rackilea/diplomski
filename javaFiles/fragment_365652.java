public class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
        private Thread thread;

        private Throwable exception;

        public void uncaughtException(Thread t, Throwable e) {
            thread = t;
            exception = e;
            thread.setRunning(false);
        }
    }
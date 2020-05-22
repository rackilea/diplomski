public class WrappedRunnable implements Runnable {
      private final Runnable delegate;
      public WrappedRunnable(Runnable delegate) {
          this.delegate = delegate;
      }
      public void run() {
          if (!shutdown) {
             delegate.run();
          }
      }
 }
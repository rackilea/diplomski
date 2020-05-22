import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * PauseableThread is a Thread with pause/resume and cancel methods.
 *
 * The meat of the process must implement `step`.
 *
 * You can either extend this and implement `step` or use the factory.
 *
 * Note that I cannot extend Thread because my resume will clash with Thread's deprecated one. 
 *
 * Usage: Either write a `Stepper` and run it in a `PausableThread` or extend `PausableThread` and call `blockIfPaused()` at appropriate points.
 */
public abstract class PauseableThread implements Runnable {
  // The lock.
  // We'll hold a read lock on it to pause the thread.
  // The thread will momentarily grab a write lock on it to pause.
  // This way you can have multiple pausers using normal locks.
  private final ReadWriteLock pause = new ReentrantReadWriteLock();
  // Flag to cancel the wholeprocess.
  private volatile boolean cancelled = false;
  // The exception that caused it to finish.
  private Exception thrown = null;

  @Override
  // The core run mechanism.
  public void run() {
    try {
      while (!cancelled) {
        // Block here if we're paused.
        blockIfPaused();
        // Do my work.
        step();
      }
    } catch (Exception ex) {
      // Just fall out when exception is thrown.
      thrown = ex;
    }
  }

  // Block if pause has been called without a matching resume.
  private void blockIfPaused() throws InterruptedException {
    try {
      // Grab a write lock. Will block if a read lock has been taken.
      pause.writeLock().lockInterruptibly();
    } finally {
      // Release the lock immediately to avoid blocking when pause is called.
      pause.writeLock().unlock();
    }

  }

  // Pause the work. NB: MUST be balanced by a resume.
  public void pause() {
    // We can wait for a lock here.
    pause.readLock().lock();
  }

  // Resume the work. NB: MUST be balanced by a pause.
  public void resume() {
    // Release the lock.
    pause.readLock().unlock();
  }

  // Stop.
  public void cancel() {
    // Stop everything.
    cancelled = true;
  }

  // start - like a thread.
  public void start() {
    // Wrap it in a thread.
    new Thread(this).start();
  }

  // Get the exceptuion that was thrown to stop the thread or null if the thread was cancelled.
  public Exception getThrown() {
    return thrown;
  }

  // Create this method to do stuff. 
  // Calls to this method will stop when pause is called.
  // Any thrown exception stops the whole process.
  public abstract void step() throws Exception;

  // Factory to wrap a Stepper in a PauseableThread
  public static PauseableThread make(Stepper stepper) {
    StepperThread pauseableStepper = new StepperThread(stepper);
    // That's the thread they can pause/resume.
    return pauseableStepper;
  }

  // One of these must be used.
  public interface Stepper {
    // A Stepper has a step method.
    // Any exception thrown causes the enclosing thread to stop.
    public void step() throws Exception;
  }

  // Holder for a Stepper.
  private static class StepperThread extends PauseableThread {
    private final Stepper stepper;

    StepperThread(Stepper stepper) {
      this.stepper = stepper;
    }

    @Override
    public void step() throws Exception {
      stepper.step();
    }
  }

  // My test counter.
  static int n = 0;

  // Test/demo.
  public static void main(String[] args) throws InterruptedException {

    try {
      // Simple stepper that just increments n.
      Stepper s = new Stepper() {
        @Override
        public void step() throws Exception {
          n += 1;
          Thread.sleep(10);
        }
      };
      PauseableThread t = PauseableThread.make(s);
      // Start it up.
      t.start();
      Thread.sleep(1000);
      t.pause();
      System.out.println("Paused: " + n);
      Thread.sleep(1000);
      System.out.println("Resuminng: " + n);
      t.resume();
      Thread.sleep(1000);
      t.cancel();
    } catch (Exception e) {
    }
  }
}
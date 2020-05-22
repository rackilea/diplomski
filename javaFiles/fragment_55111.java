import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * A future that wraps another future, and behaves just like it, except that at the point
 * when the future completes a hook is called.
 *
 * @param <T> the type returned by the future.
 */
public abstract class HookedFuture<T> implements Future<T> {

  private final Future<T> innerFuture;

  /** Make sure hook is only called once */
  private boolean hookCalled = false;

  public HookedFuture(Future<T> future) {
    innerFuture = future;
  }

  /** Client implements this hook, which will be called back on completion of the first
   *   get() */
  protected abstract void futureResultIs(T result);

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    return innerFuture.cancel(mayInterruptIfRunning);
  }

  @Override
  public boolean isCancelled() {
    return innerFuture.isCancelled();
  }

  @Override
  public boolean isDone() {
    return innerFuture.isDone();
  }

  @Override
  public T get() throws InterruptedException, ExecutionException {
    T result = innerFuture.get(); // may block here
    if (!hookCalled) {
      futureResultIs(result);
      hookCalled = true;
    }
    return result;
  }

  @Override
  public T get(long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
    T result = innerFuture.get(timeout, unit); // may block here
    if (!hookCalled) {
      futureResultIs(result);
      hookCalled = true;
    }
    return result;
  }
}
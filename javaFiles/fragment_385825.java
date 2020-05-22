public abstract class ThreadContextRunnable implements Runnable {

  private final Map context = ThreadContext.getContext();

  @Override
  public final void run() {
    if (context != null) {
      ThreadContext.putAll(context);
    }
    try {
      runWithContext();
    } finally {
      ThreadContext.clearAll();
    }
  }

  protected abstract void runWithContext();
}
class CallbackTask implements Runnable {

  private final Runnable task;

  private final Callback callback;

  CallbackTask(Runnable task, Callback callback) {
    this.task = task;
    this.callback = callback;
  }

  public void run() {
    task.run();
    callback.complete();
  }

}
private class SchedulerRunnable implements Runnable {
  private SchedulerInterface schedulerInterface;

  SchedulerRunnable(SchedulerInterface schedulerInterface) {
    this.schedulerInterface = schedulerInterface;
  }
}
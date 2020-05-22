public interface CompletedTask {
  void completed(boolean succes);
}

// change SimulatedAnnealingCallable to receive CompletedTask in constructor
// and call the instanc's completed method

public LogicClass implements CompletedTask {

  private void someFunc() {
    final SimulatedAnnealingCallable simulatedAnnealingCallable =
            new SimulatedAnnealingCallable(this, schedule);
    executorService.submit(simulatedAnnealingCallable);
  }

  public void completed(boolean succes) {
    System.out.println("task is completed with " + success);
  }
}
public class HelperClass {
  private ExperimentInstance experimentInstance;

  public HelperClass(ExperimentInstance experimentInstance) {
    this.experimentInstance = experimentInstance;
  }

  public void hasStarted() {
    experimentInstance.hasStarted = Boolean.TRUE;
    experimentInstance.update();
  }
}

public class ContainingClass extends UntypedActor {
  ...
  private HelperClass helperClass = new HelperClass(experimentInstance);
  ...
  new Timer().schedule(new TimerTask() {
    @Override
    public void run() {
      helperClass.hasStarted();
    }
  }, lifetimeInMs);
  ...
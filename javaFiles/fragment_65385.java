@Override
public StepExecution start(StepContext stepContext) {

  return new Execution(stepContext, this);
}

private final static class Execution extends SynchronousNonBlockingStepExecution<Void> {

  private transient final ExampleBuildStep step;

  protected Execution(
    @Nonnull StepContext context,
    ExampleBuildStep step) {
    super(context);
    this.step = step;
  }

  @Override
  protected Void run() throws Exception {

    FilePath workspace = getContext().get(FilePath.class);
    workspace.mkdirs();
    step.perform(
      getContext().get(Run.class),
      workspace,
      getContext().get(Launcher.class),
      getContext().get(TaskListener.class),
      getContext().get(EnvVars.class));
    return null;
  }
}
@Extension
public static class DescriptorImpl extends StepDescriptor {

  @Override
  public Set<? extends Class<?>> getRequiredContext() {
    return ImmutableSet.of(FilePath.class, Run.class, Launcher.class, TaskListener.class, EnvVars.class);
  }

  @Override
  public String getFunctionName() {
    return "run_your_step";
  }

  public boolean isApplicable(Class<? extends AbstractProject> aClass) {
    // Indicates that this builder can be used with all kinds of project types
    return true;
  }

  public String getDisplayName() {
    return "Example of step plugin";
  }
}
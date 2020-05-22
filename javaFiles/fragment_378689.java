@Override
public boolean perform(AbstractBuild build, Launcher launcher,
  BuildListener listener) throws IOException, InterruptedException {
    ...
    final EnvVars env = build.getEnvironment(listener);
    String expandedDbUrl = env.expand(dbUrl);
    ...
}
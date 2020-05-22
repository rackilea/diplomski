class EntryPoint {
  public static void main(String[] args) {
    YourApp yourApp = Guice.createInjector(yourListOfModules())
        .getInstance(YourApp.class);
    yourApp.run();
  }
}

class YourApp {
  @Inject DependencyA dependencyA;
}

class DependencyA {
  @Inject DependencyB dependencyB;
}

class DependencyB {
  /** This is injected once, so you'll always only get the same instance. */
  @Inject DependencyC dependencyC;
  /** By injecting the provider, you can get multiple instances. */
  @Inject Provider<DependencyD> dependencyD;
}
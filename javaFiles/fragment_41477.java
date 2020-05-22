class MyExperiment implements Config {
  private final Map<String, String> props;
  MyExperiment(Map<String, String> props) { this.props = props; }

  void someMethod() {
    // read property from injected configuration
    String someProp = someProperty();
  }
}
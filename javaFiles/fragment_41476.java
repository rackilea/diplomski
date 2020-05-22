interface Config {
  Map<String, String> getProperties();
  default String someProperty() {
    return getProperties().get("some-prop");
  }
  // ... more utility methods follow
}
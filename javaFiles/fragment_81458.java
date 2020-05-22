eventBus.register(new Object() {
  @Subscribe
  public void loadConfig(ConfigurationChangeEvent cce) {
    SampleMailer.loadConfig(cce);
  }
});
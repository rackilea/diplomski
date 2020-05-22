Task task = new Task<Void>() {
  @Override
  protected Void call() throws Exception {
      initStubGamepad();
      return null;
  }
}
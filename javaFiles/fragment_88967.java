class MyRunListener extends RunListener {
  private static final Description FAILED = Description.createTestDescription('failed', 'failed')

  @Override
  void testFailure(Failure failure) throws Exception {
    failure.description.addChild(FAILED)
  }

  @Override
  void testFinished(Description description) throws Exception {
    if (description.children.contains(FAILED))
      // Process failed tests here...
    else
      // Process passed tests here...
  }
}
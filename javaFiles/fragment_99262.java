public class MyTestRunner extends BlockJUnit4ClassRunner {

  public MyTestRunner(Class<?> klass) throws InitializationError {
    super(klass);
  }

  @Override
  public void run(RunNotifier notifier) {
    notifier.addListener(new RunListener() {
        @Override
        public void testFailure(Failure failure) throws Exception {
            Throwable exception = failure.getException();
            //insert your logs here
        }
    });
    super.run(notifier);
  }

}
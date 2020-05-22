protected Statement classBlock(final RunNotifier notifier) {
  return new Statement() {
    @Override
    public void evaluate() throws Throwable {
      for (int i = 0; i < repeats; i++) {
        super.classBlock(notifier).evaluate();
      }
    }
  };
}
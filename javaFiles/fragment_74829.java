@Rule
public TestWatcher watcher = new TestWatcher() {
  @Override
  public Statement apply(Statement base, Description description) {
    // You can replace this hard-coded test name and delay with something
    // more dynamic
    if (description.getMethodName().equals("infinity")) {
      return new FailOnTimeout(base, 200);
    }

    return base;
  }
};
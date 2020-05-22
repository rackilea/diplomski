@Override
public final void run(final TestResult result) {
    result.startTest(this);
    result.runProtected(this, () -> testCase.run());
    result.endTest(this);
}
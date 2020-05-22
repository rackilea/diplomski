public class MyResultPrinter extends ResultPrinter {
    public MyResultPrinter(PrintStream writer) {
        super(writer);
    }
        @Override
    protected void printFooter(TestResult result) {
        if (result.wasSuccessful()) {
            // just drop the OK messages
        } else {
            // but print the failures
            super.printFooter(result);
        }
    }
}
public class RunJunitTestRunListener {
    private static class MyListener extends RunListener {
        private long runStart = 0L;
        private long testStart = 0L;

        @Override
        public void testRunStarted(Description description) throws Exception {
            System.out.println("runStarted");
            runStart = System.currentTimeMillis();
            super.testRunStarted(description);
        }

        @Override
        public void testRunFinished(Result result) throws Exception {
            System.out.println("runFinished " + (System.currentTimeMillis() - runStart) + "ms");
            super.testRunFinished(result);
        }

        @Override
        public void testStarted(Description description) throws Exception {
            System.out.println("testStarted");
            testStart = System.currentTimeMillis();
            super.testStarted(description);
        }

        @Override
        public void testFinished(Description description) throws Exception {
            System.out.println("testFinished " + (System.currentTimeMillis() - testStart) + "ms");
            super.testFinished(description);
        }
    }

    public static void main(String[] args) {
        JUnitCore core= new JUnitCore();
        core.addListener(new MyListener());
        core.run(TimingTest.class);
    }
}
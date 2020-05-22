//
    @Rule
    public TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
        }

        @Override
        protected void succeeded(Description description) {
        }

        @Override
        protected void failed(Throwable e, Description description) {
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
        }

        @Override
        public void finished(Description description) {
        }
    };
//...
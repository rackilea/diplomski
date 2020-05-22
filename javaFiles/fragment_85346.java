public class MainApp {

    private final Service<Void> testService = new Service<Void>() {
        @Override
        protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    // code to execute on background thread here:
                    while (! isCancelled() ) {
                        // ...
                    }
                }
            }
        }
    };

    public Service<Void> getTestService() {
        return testService();
    }

    // ...
}
public class StatusTest {

    enum Status {
        FAILED { 
            @Override
            public Runnable getRunner() {
                return new Runnable() { 
                    private String text = "Test " + System.currentTimeMillis();
                    @Override
                    public void run() {
                        System.out.println(text);
                    }
                };
            }
            @Override
            public void message() {
                getRunner().run();
            }
        };
        public abstract void message();
        public abstract Runnable getRunner();
    }

    public static void main(String[] args) {
        Status status = Status.FAILED;
        status.message();
        Runnable runner = status.getRunner();
        runner.run();
    }
}
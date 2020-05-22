public class StatusTest {

    enum Status {
        FAILED{  
            class Test implements Runnable { 
                private String text = "Test " + System.currentTimeMillis();
                @Override
                public void run() {
                    System.out.println(text);
                }
            }
            @Override
            public Runnable getRunner() {
                return new Test();
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
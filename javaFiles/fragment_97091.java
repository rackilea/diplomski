public class Test {

    public static void main(String[] args) {
        final NonconcurrentTask shared = new NonconcurrentTask() {
            private boolean working = false;

            protected void doTask() {
                System.out.println("Working: "
                        + Thread.currentThread().getName());
                if (working) {
                    throw new IllegalStateException();
                }
                working = true;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (!working) {
                    throw new IllegalStateException();
                }
                working = false;
            }
        };

        Runnable taskWrapper = new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    shared.run();
                }
            }
        };
        for (int i = 0; i < 100; i++) {
            new Thread(taskWrapper).start();
        }
    }

}
public class Test {
    public static long count = 0;

    public static void main(String[] args) {
        for (int run = 0; run < 5; ++run) {
            Test.count = 0;

            Thread[] threads = new Thread[10];

            for (int i = 0; i < threads.length; ++i) {
                threads[i] = new Thread(new Runnable() {
                    public void run() {
                        for (long i = 0; i < (10 * 1000 * 1000 * 1000); ++i) {
                            Test.count += 1;
                        }
                    }
                });
            }

            for (int i = 0; i < threads.length; ++i) {
                threads[i].start();
            }

            for (int i = 0; i < threads.length; ++i) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Test.count);
        }
    }
}
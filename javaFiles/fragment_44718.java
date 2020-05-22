public class Main {
    static String HI = "Hello World";

    static {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println(HI);
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
    }
}
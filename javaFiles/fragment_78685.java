public class Test {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            System.in.read();   // Block for input
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        t.start();
        while (true) {
            System.out.println("State: " + t.getState());
            Thread.sleep(1000);
        }
    }
}
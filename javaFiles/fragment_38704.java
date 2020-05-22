public class Foo {
    public static void main(final String[] args) throws Exception {
        Thread sleepThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }
            }
        });
        sleepThread.start();
        Thread.sleep(500);
        sleepThread.interrupt();
    }
}
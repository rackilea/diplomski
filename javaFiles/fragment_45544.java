public class Deadlock {
    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();
        new Thread() {
            @Override
            public void run() {
                synchronized (a) {
                    /* wait for a second to make it likely the other thread can acquire b */
                    try { Thread.sleep(1000); } catch (Exception e) {  }
                    synchronized (b) {
                        System.out.println("Acquired a, then b.");
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                synchronized (b) {
                    /* wait for a second to make it likely the other thread can acquire a */
                    try { Thread.sleep(1000); } catch (Exception e) {  }
                    synchronized (a) {
                        System.out.println("Acquired b, then a.");
                    }
                }
            }
        }.start();
    }
}
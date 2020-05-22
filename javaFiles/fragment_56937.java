public class FixedVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        public void run() {
            while (!getReady())
                Thread.yield();
            System.out.println(getNumber());
        }
    }

    public static synchronized boolean getReady() {
        return FixedVisibility.ready;
    }

    public static synchronized void setReady(boolean ready) {
        FixedVisibility.ready = ready;
    }

    public static synchronized int getNumber() {
        return FixedVisibility.number;
    }    

    public static synchronized void setNumber(int number) {
        FixedVisibility.number = number;
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        FixedVisibility.setNumber(42); 
        FixedVisibility.setReady(true); 
    }
}
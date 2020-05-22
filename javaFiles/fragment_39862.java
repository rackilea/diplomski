import java.lang.reflect.Field;

public class SSCCE {
    static class T extends Thread {
        private int i;

        public T(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            while(true) {
                System.out.println("T: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // ignore
                }
            }
        }
    }

    static class R implements Runnable {
        private int i;

        public R(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            while(true) {
                System.out.println("R: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // ignore
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new T(1);
        Thread t2 = new Thread(new R(2));

        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // ignore
        }

        setI(t1,3);
        setI(t2,4);
    }

    static void setI(Thread t, int newVal) {
        // Secret sauce here...
        try {
            Field fTarget = Thread.class.getDeclaredField("target");
            fTarget.setAccessible(true);
            Runnable r = (Runnable) fTarget.get(t);

            // This handles the case that the service overrides the run() method
            // in the thread instead of setting the target runnable
            if (r == null) r = t;

            Field fI = r.getClass().getDeclaredField("i");
            fI.setAccessible(true);
            fI.setInt(r, newVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
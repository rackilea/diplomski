package demo.thread;

public class ABCPuzzle {

    private static class RunnableImpl implements Runnable {

        private String nextThread;
        private ExecServ execServ;

        public RunnableImpl(ExecServ execServ, String nextThread) {
            this.execServ = execServ;
            this.nextThread = nextThread;
        }

        @Override
        public void run() {

            String threadName = Thread.currentThread().getName();

            synchronized (execServ) {
                try {
                    while (true) {
                        if (execServ.key > 'Z')
                            break;

                        if (threadName.equals(execServ.current)) {
                            System.out.println(threadName + " consuming "  + execServ.key);
                            Thread.sleep(1000);
                            execServ.key++;
                            execServ.current = nextThread;
                            execServ.notifyAll();
                        } else
                            execServ.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ExecServ {
        private String current, next;
        private char key = 'A';
    }

    public static void main(String[] args) {

        ExecServ execServ = new ExecServ();
        execServ.current = "t1";

        Thread t1 = new Thread(new RunnableImpl(execServ, "t2"), "t1");
        Thread t2 = new Thread(new RunnableImpl(execServ, "t3"), "t2");
        Thread t3 = new Thread(new RunnableImpl(execServ, "t4"), "t3");
        Thread t4 = new Thread(new RunnableImpl(execServ, "t1"), "t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
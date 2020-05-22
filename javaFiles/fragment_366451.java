public class ThreadInterruptRestart {

    public static void main(String[] args) {
        new ThreadInterruptRestart().callthread();
    }

    public void callthread() {

        final Object mutex = new Object();

        final Thread myThread = new Thread("myThread") {
            @Override
            public void run() {
                final Thread _this = this;

                Thread interruptingThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            // this is not the interrupt we are interested in
                            e.printStackTrace();
                        }
                        if (true) {
                            System.out.println("interrupting " + _this + " from thread " + this);
                            synchronized (mutex) {
                                _this.interrupt();
                            }
                        }
                    }
                }, "interrupting thread");
                interruptingThread.start();

                for (int x = 0; x < 75000; x++) {
                    // using this and thread sleep for repeated timed code
                    // within a thread
                    synchronized (mutex) {
                        System.out.println(x);
                        // do other stuff here
                    }
                    if (Thread.interrupted()) {
                        // this is the interrupt we want to handle
                        System.out.println("" + this + " interrupted!");
                        // reset the loop counter
                        x = 0;
                    }
                }
            }
        };
        myThread.start();
    }
}
public class ThreadInterruptRestart {

    public static void main(String[] args) {
        new ThreadInterruptRestart().callthread();
    }

    public void callthread() {

        final Thread myThread = new Thread("myThread") {
            @Override
            public void run() {
                final Thread _this = this;

                Thread interruptingThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            // this is not the interrupt we are interested in
                            e.printStackTrace();
                        }
                        if (true) {
                            System.out.println("interrupting " + _this + " from thread " + this);
                            _this.interrupt();
                        }
                    }
                }, "interrupting thread");
                interruptingThread.start();

                for (int x = 0; x < 750; x++) {
                    // using this and thread sleep for repeated timed code
                    // within a thread
                    try {
                        System.out.println(x);
                        Thread.sleep(10);
                    } catch (InterruptedException e1) {
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
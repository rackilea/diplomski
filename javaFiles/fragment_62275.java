public class FreeThread extends HotThread {

    private final int timeout;
    Timer timer;
    InterruptByTimer task; 

    public FreeThread(int timeout) {
        super();
        this.timeout = timeout;
        timer = new Timer();
        task = new InterruptByTimer(timer, Thread.currentThread());
        timer.schedule(task, timeout);
    }

     private class InterruptByTimer extends TimerTask {
        Timer timer;
        Thread thread;
        public InterruptByTimer(Timer timer, Thread thread){
            this.timer = timer;
            this.thread = thread;
        }
        @Override
        public void run(){

            interruptThisThread(timer);
        }
    }

    public void interruptThisThread(Timer timer, Thread thread){
        timer.cancel();
        thread.interrupt();
    }

}
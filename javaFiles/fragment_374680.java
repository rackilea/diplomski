public class ThreadControl {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable("MyRunnable");
        Thread thread = new Thread(myRunnable);
        thread.setDaemon(true);
        thread.start();

        myRunnable.whoAmI();//call method from within thread

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
        }
        myRunnable.isStopped.set(true);//stop thread
    }

 static class MyRunnable implements Runnable {
        public String threadName;
        public AtomicBoolean isStopped=new AtomicBoolean(false);

        public MyRunnable() {
        }

        public MyRunnable(String threadName) {
            this.threadName = threadName;
        }

        public void run() {
            System.out.println("Thread started, threadName=" + this.threadName + ", hashCode="
                    + this.hashCode());

            while (!this.isStopped.get()) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread looping, threadName=" + this.threadName + ", hashCode="
                        + this.hashCode());
            }
        }

        public void whoAmI() {
            System.out.println("whoAmI, threadName=" + this.threadName + ", hashCode="
                    + this.hashCode());
        }

    }

}
class ThreadTask implements Runnable {
    private volatile boolean flag = false;

    public void setFlag(boolean value) {
        flag = value;
    }

    public void run() {
        System.out.println("Started");
        while(!flag) {
           // execute code
        }
        System.out.println("Stopped");
    }
}
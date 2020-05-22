public App1 implements Runnable {

    private final Integer shared;/* Not spending time on auto-boxing */

    public App1(Integer sharedNum) {
        shared = sharedNum;
    }

    @Override
    public void run() {
        synchronization(shared){
            //code here
        }
    }
}

public App1Test {
    private final int forSharing = 14;
    public static void main(String[] args) {
        ExecutorService taskList = Executors.newFixedThreadPool(poolSize);
        taskList.execute(new App1(forSharing));
        // and lob lob
    }
}
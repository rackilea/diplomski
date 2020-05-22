public class Test {

    public static void main(String[] args) throws InterruptedException {

        Scheduler s = new Scheduler(100);
        ExecutorService exec = Executors.newFixedThreadPool(4);
        for(int i = 0; i < 4; i++) {
            exec.submit(new Task(s));
        }

        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);       
    }
}
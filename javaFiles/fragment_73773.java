public static void main(String[] args) throws Exception {
    MyRunnable myRunnable = new MyRunnable();
    ExecutorService service = Executors.newFixedThreadPool(1);
    service.submit(myRunnable);
    boolean isFinished = service.awaitTermination(5, TimeUnit.SECONDS);
    if(!isFinished) {
        myRunnable.done();
        String result = myRunnable.getResult();
        System.out.println(result);
    }
    service.shutdown();
}
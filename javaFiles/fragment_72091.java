private static final ExecutorService executorService = Executors.newFixedThreadPool(1);

public static void main(String[] args) {
    //do some stuff       
    final Future<Object> future = executorService.submit(new MyOtherWork());
    final Object object;
    try {
        object = future.get();
    } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
    } catch (ExecutionException ex) {
        //handle exception
    }       
    //do some other stuff

}

private static class MyOtherWork implements Callable<Object> {

    public Object call() throws Exception {
        //do stuff in another thread
    }
}
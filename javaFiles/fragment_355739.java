public class MyCallable implements Callable<Void> {
    public Void call() throws Exception {
        try {
            //Code which generates exception like below
            throw new Exception("Runtime Exception");
        } catch (Exception e1) {
            // log or throw the exception
        }
        return null; // To satisfy the method signature
    }
}
public class FooBarExecutor {
    private ExecutorService fooExecutor = Executors.newFixedThreadPool(1000);
    private ExecutorService barExecutor = Executors.newCachedThreadPool();

    public <T> Future<T> submit(Foo foo) {
        return fooExecutor.submit(foo);
    }

    public <T> Future<T> submit(Bar bar) {
        return barExecutor.submit(bar);
    }

    public <T> Future<T> submit(Object obj) {
        if (obj instanceof Foo) {
            return submit((Foo)obj);
        } else if (obj instanceof Bar) {
            return submit((Bar)obj);
        } else {
           throw new IllegalArgumentException(
              "Object should be either Foo or Bar");
        }
    }
}
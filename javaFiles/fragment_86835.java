Future<Listing> future = executor.submit(new Callable<Listing>() {
    public Listing call() throws Throwable {
        try {
            return callable.call();
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }
    }
});
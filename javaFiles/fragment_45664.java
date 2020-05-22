Executor executor = ...

Subscription upstream;

@Override public void onSubscribe(Subscription s) {
    this.upstream = s;
    executor.execute(() -> {
       Thread.sleep(5000);
       s.request(1);
       return null; // Callable
    });
}

@Override public void onNext(T item) {
    System.out.println("Start onNext");
    executor.execute(() -> {
       System.out.println("Run work");
       Thread.sleep(5000);
       System.out.println("Request more work");
       upstream.request(1);
       return null; // Callable
    });
    System.out.println("End onNext");
}
public class RunCurrentThread implements Executor {

    private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        RunCurrentThread sample = new RunCurrentThread();
        sample.observerOnMain();
        sample.runLoop();
    }

    private void observerOnMain() {
        createObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.from(this))
                .subscribe(message -> {
                    System.out.println("Observable thread " + message);
                    System.out.println("Observer thread " + Thread.currentThread().getName());
                });
        ;
    }

    public Observable<String> createObservable() {
        return Observable.create((Subscriber<? super String> subscriber) -> {
                    subscriber.onNext(Thread.currentThread().getName());
                    subscriber.onCompleted();
                }
        );
    }

    private void runLoop() throws InterruptedException {
        while(!Thread.interrupted()){
            tasks.take().run();
        }
    }

    @Override
    public void execute(Runnable command) {
        tasks.add(command);
    }
}
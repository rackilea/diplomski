Scheduler scheduler = Schedulers.from(Executors.newSingleThreadExecutor());

Subscription subscription1 = Completable.fromCallable(() -> {
  Thread.sleep(1000);
  System.out.println("first Callable executed");
  return 0;
})
    .doOnComplete(() -> System.out.println("first Completable complete"))
    .subscribeOn(scheduler)
    .subscribe();

Subscription subscription2 = Completable.fromCallable(() -> {
  Thread.sleep(1000);
  System.out.println("second Callable executed");
  return 0;
})
    .doOnComplete(() -> System.out.println("second Completable complete"))
    .subscribeOn(scheduler)
    .subscribe();

CompositeSubscription subscriptions = new CompositeSubscription();
subscriptions.addAll(subscription1, subscription2);
subscriptions.clear();
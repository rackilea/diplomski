observable.doOnNext(() -> {
  Completable
    .fromCallable(() -> information.saveSomething(v))
    .subscribeOn(mainThread())
    .subscribe();
})
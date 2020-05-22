Observable.create(subscriber -> {
    subscriber.onNext(12345);
})
  .flatMap(value -> Observable.just(value)
        .mergeWith(Observable.timer(10, TimeUnits.SECONDS).map(/* define your "random" value here */))
  )
  .subscribeOn(...)
  .observeOn(...)
  .subscribe(new Subscriber<Long>(){
      @Override
      public void onNext(Long aLong) {
        //Do Something
      }
  })
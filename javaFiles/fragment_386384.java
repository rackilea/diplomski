observable.subscribeOn(Schedulers.io())
       .observeOn(AndroidSchedulers.mainThread())
       .concatMap(new Function<Integer, ObservableSource<Integer>>() {
       @Override
       public ObservableSource<Integer> apply(final Integer integer) {
           return Observable.interval(2, TimeUnit.SECONDS)
                     .take(1)
                     .map(new Function<Integer, Integer>() {
                          @Override
                          public Integer apply(Integer aLong) {
                               return integer;
                          }
                     });
             }
      })
      .subscribe(observer());
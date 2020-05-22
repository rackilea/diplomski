public static <T> Single<T> latestSuccess(Single<T>... sources) {
     return Single.defer(() -> {
         AtomicReference<T> last = new AtomicReference<T>();
         return Observable.fromArray(sources)
             .concatMap(source ->
                  source.doOnSuccess(last::lazySet)
                  .toObservable()
                  .onErrorResumeNext(Observable.empty())
             )
             .ignoreElements()
             .andThen(Single.fromCallable(() -> {
                 if (last.get() == null) {
                     throw new NoSuchElementException();
                 }
                 return last.get();
             }));
     });
}
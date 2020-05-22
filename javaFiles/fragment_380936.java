public <T> Observable<T> streamToObservable(Stream<T> stream) {
  return Observable.generate(
    () -> stream.iterator(),
    (ite, emitter) -> {
      if (ite.hasNext()) {
        emitter.onNext(ite.next());
      } else {
        emitter.onComplete();
      }
    }
  );
}
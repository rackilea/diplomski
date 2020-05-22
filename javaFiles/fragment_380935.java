fun <T> Stream<T>.toObservable(): Observable<T> {
  return Observable.generate(
    Callable { iterator() },
    BiConsumer { ite, emitter ->
      if (ite.hasNext()) {
        emitter.onNext(ite.next())
      } else {
        emitter.onComplete()
      }
    }
  )
}
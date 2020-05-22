fun <T> Stream<T>.toFlowable(): Flowable<T> {
  return Flowable.generate(
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
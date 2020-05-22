Observable<Long> retries = 
  Observable
    .just(1, 2, 4, 8, 16)
    .concatWith(Observable.just(30).repeat())
    .flatMap(n -> Observable.timer(n, TimeUnit.SECONDS));

Observable
  .just(request)
  .map(this::submitAndGetId)
  .flatMap(id -> 
     retries
        .filter(n -> reportIsDone(id))
        .map(n -> id)
        .first()
  )
  .map(this::getReport);
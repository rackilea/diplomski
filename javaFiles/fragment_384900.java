Observable
  .just(request)
  .map(this::submitAndGetId)
  .flatMap(id -> 
    Observable
        .interval(1, TimeUnit.SECONDS)
        .filter(n -> reportIsDone(id))
        .map(n -> id)
        .first()
  )
  .map(this::getReport);
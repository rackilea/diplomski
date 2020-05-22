Completable.merge(
  observable1
    .doOnNext(this::onACompleted)
    .doOnError(this::onAFailed)
    .onErrorResumeNext( Completable.complete() )
    .toCompletable(),
  observable2
    .doOnNext(this::onBCompleted)
    .doOnError(this::onBFailed)
    .onErrorResumeNext( Completable.complete() ),
    .toCompletable() )
.subscribe( ignore -> {}, 
            error -> {},
            () -> { processCompletion(); } );
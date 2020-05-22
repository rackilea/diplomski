createAccount()
    .flatMap(
        createdAcc -> getAccount(accountId)
            .flatMap(
                status -> status == "procesing" ?
                          Single.error(new Throwable()) :
                          Single.just(status)
            )
            .doOnError(throwable -> Log.e("", "retrying"))
            .retryWhen(errors -> errors.flatMapSingle(error -> Single.timer(5, TimeUnit.SECONDS)))
    )
    .subscribe();
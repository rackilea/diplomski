Observable.just(Boolean.TRUE)
    .flatMap( ignored -> service
                           .getPosts(offset,limit,
                                      PreferencesUtils.getAccessTokenKey()) )
    .subscribeOn(Schedulers.computation())
    .doOnNext(response -> {
        if (!response.isSuccessful()) throw new TokenException();
    })
    .retryWhen( error -> error.flatMap( f ->
      {
        if ( f instanceof TokenException ) {
          return service.refreshToken(PreferencesUtils.getAccessTokenKey(), PreferencesUtils.getRefreshTokenKey())
            .doOnNext( response -> {
                PreferencesUtils.saveAccessToken(response.body().getAccessToken());
                PreferencesUtils.saveRefreshToken(response.body().getRefreshToken());
            });
        }
        return Observable.error(f);
      })
    )
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe( /* do stuff */ );
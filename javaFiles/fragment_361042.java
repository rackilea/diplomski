override fun getSomething(): Single<Something> {
      return cache.getSomething()
        .switchIfEmpty(
          Maybe.defer {
            feed.getSomething().toMaybe()
          }
        )
        .toSingle()
  }
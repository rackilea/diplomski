override fun getSomething(): Single<Something> {
      return cache.getSomething()
        .toSingle()
        .onErrorResumeNext {
           feed.getSomething()
        }
  }
Completable config = prepareConfigurationAsync()
     .flatMapCompletable(success ->
         System.out.println(success);
         return Completable.mergeArray (
             prepareLongAsyncTask1(success)
                 .doOnSuccess(innerSuccess -> /* ... */)
                 .toCompletable(),
             prepareLongAsyncTask2(success)
                 .doOnComplete(() ->  /* ... */)
         )
      );

  config
  .subscribe( () -> /* completed */, error -> /* error'd */);
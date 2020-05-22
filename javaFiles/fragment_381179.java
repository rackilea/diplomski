public void onHandleIntent(Intent intent) {
      Observable.zip(
           getHashtags().subscribeOn(Schedulers.newThread()),
           getSearchtags().subscribeOn(Schedulers.newThread()),
           new Func2<List<String>, List<String>, Void>() {
                 @Override
                 public Void call(List<String> hashtags, List<String> searchtags) {
                       // do something with your data
                       return null;
                 }
           }
      )
      .subscribe();
 }

 private Observable<List<String>> getHashtags() {
      return Observable.defer(new Func0<Observable<List<String>>>() {
                @Override
                public Observable<List<String>> call() {
                    // fetch your data
                    return null;
                }
      };
 }
Subscription subscription =   Observable.create(new Observable.OnSubscribe<Response>() {
        OkHttpClient client = new OkHttpClient();
          @Override
          public void call(Subscriber<? super Response> subscriber) {
            try {
              Response response = client.newCall(new Request.Builder().url("your url").build()).execute();
              if (response.isSuccessful()) {
                  if(!subscriber.isUnsubscribed()){
                     subscriber.onNext(response);
                  }
                  subscriber.onCompleted();
              } else if (!response.isSuccessful() && !subscriber.isUnsubscribed()) {
                  subscriber.onError(new Exception("error"));
                }
            } catch (IOException e) {
              if (!subscriber.isUnsubscribed()) {
                  subscriber.onError(e);
              }
            }
          }
        })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<Response>() {
              @Override
              public void onCompleted() {

              }

              @Override
              public void onError(Throwable e) {

              }

              @Override
              public void onNext(Response response) {

              }
            });
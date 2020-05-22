apiCall
  .observeOn(AndroidSchedulers.mainThread())
  .startWith(Observable.defer(() -> {
      if (!NetworkUtils.isConnected(context)) {
          return Observable.error(new ConnectException("network not connected"));
      } else {
          return Observable.empty();
      }
  }))
  .doOnSubscribe(() -> viewManager.showLoader())
  .doOnCompleted(() -> viewManager.hideLoader())
  .doOnError(throwable -> viewManager.hideLoader());
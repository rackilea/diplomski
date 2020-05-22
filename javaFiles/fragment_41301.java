public Observable<Response> prepareSomething() {
        return api.requestSomthing()
                .observeOn(Schedulers.io())
                .flatMap(response -> Observable.fromIterable(response.getAssetsList())
                        .flatMap( asset -> downloadAsset(asset))
                        .toList()
                        .flatMapObservable(downloadedAssets -> Observable.just(response))
                );
    }
Observable.defer(() -> Observable.from(Utility.getPagesFromServer()))
    .map(page -> Utility.getJSONObjectContainingLines(page))
    .map(jsonResponse -> getLines(jsonResponse.getJSONObject()))
    .flatMapIterable(lines -> lines)
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(line -> {
        //Do something with your line
    }, throwable -> throwable.printStackTrace(), () -> {
        //on complete
    });
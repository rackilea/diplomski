Observable.just(createContainer(true))
        .subscribeOn(Schedulers.io())
        .lift(new ContainerCheck())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext(container -> doSomethingWhenSuccess())
        .map(container -> container.books)
        .flatMap(Observable::from)
        .subscribe(book -> {
            doSomethingForBook(book);
        }, e -> doSomethingWhenFail());
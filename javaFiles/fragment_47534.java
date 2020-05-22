ConcurrentHashMap<String, PublishSubject<Void>> map =
     new ConcurrentHashMap<>();


Observable.from(urls)
.concatMap(url -> {
    PublishSubject<Void> subject = PublishSubject.create();
    if (map.putIfAbsent(url, subject) == null) {
        return downloadFile(url)
            .takeUntil(subject)
            .doAfterTerminate(() -> map.remove(url))
            .doOnUnsubscribe(() -> map.remove(url));
    }
    return Observable.empty();
})
.subscribe(file -> addFileToUI(file), Throwable::printStackTrace);

// sometime later

PublishSubject<Void> ps = map.putIfAbsent("someurl", PublishSubject.create());
ps.onCompleted();
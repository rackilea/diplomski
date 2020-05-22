val fromServer1 = Observable.fromCallable {
    listOfApps = parseAppsList(Jsoup.connect("server1.host.com"))
    return@fromCallable listOfApps
}
        .subscribeOn(Schedulers.io())


val fromServer2 = Observable.fromCallable {
    listOfApps = parseAppsList(Jsoup.connect("server2.host.com"))
    return@fromCallable listOfApps
}
        .subscribeOn(Schedulers.io())


Observable.merge(fromServer1, fromServer2)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ apps ->
            // Note that this callback will be called once per server
            appsList.addAll(apps)
        }, { exception ->
            // Show an error message
        })
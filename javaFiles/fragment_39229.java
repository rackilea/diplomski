// What you're doing
Observable.fromCallable {
    listOfApps = parseAppsList(Jsoup.connect("server1.host.com"))
    return@fromCallable listOfApps
}
        // Where you're doing it
        .subscribeOn(Schedulers.io())
        // Where you're observing results
        .observeOn(AndroidSchedulers.mainThread())
        // What you're doing with those results
        .subscribe({ apps ->
            appsList.addAll(apps)
        }, { exception -> 
            // Show an error message
        })
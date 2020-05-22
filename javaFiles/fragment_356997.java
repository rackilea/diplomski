IContactWebApi api = retrofit.create(IContactWebApi.class);
Observable.interval(interval, TimeUnit.SECONDS)
        .flatMap(i -> api.getContactsByGroupSync(uid))
        .map(Groups::getGroups)
        .subscribeOn(Schedulers.io())
        .onErrorResumeNext(Observable.empty())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(groups -> handleGroups(groups));
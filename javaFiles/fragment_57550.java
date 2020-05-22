final List<Observable<Item>> tasks = gridItems()
    .stream()
    .map(item -> {
        final int seconds = ThreadLocalRandom.current().next(0, 5);
        return Observable.timer(seconds, TimeUnits.SECONDS).map(ignore -> item);
     })
    .collect(Collectors.toList());

Observable.merge(tasks)
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(item -> {
        //One item has completed. Take the "item" value
        // and use it to update your UI.
    }, t -> { /*No error handling*/}, () -> /*All items finished*/);
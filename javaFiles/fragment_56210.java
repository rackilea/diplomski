fun doTask(items: List<String>):Observable<Boolean>{
        return Observable.fromIterable(items)
                .flatMap { processItem(it) }
                .toList()
                .toObservable()
                .flatMap { finalTask() }
    }
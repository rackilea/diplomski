Observable
                .fromIterable(largeList)
                .filter { it.name.contains(query) }
                .toList() 
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { ... }
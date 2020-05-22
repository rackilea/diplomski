Observable
                    .fromIterable(largeList)
                    .filter { it.name.contains(query) }
                    .toList(capacityHint)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe { ... }
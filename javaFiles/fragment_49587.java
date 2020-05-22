observable.flatMap(list -> {
     return Observable.from(list)
                        .filter(Item::isFiltered)
                        .toList()
  })
  .subscribe(this::onNext, this::onError)
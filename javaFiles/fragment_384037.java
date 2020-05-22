dummyProvider
    .getAllObjects()
    .map(mapper::mapToDateObject)
    .groupBy { it.getDateTime().isAfterNow() }
    .toList()
    .flatMapObservable { list ->
        list.first { it.key }.sorted { ... }
             .concatWith(list.first { !it.key }.sorted { ... }) }
    .toList()
public Single<List<Model>> getData(List<String> identifiers) {
    return Observable
        .from(identifiers)
        .concatMap(identifier -> getDataPerItem(identifier))
        .concatMapIterable(it -> it)
        .toList();
}
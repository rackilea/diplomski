public Single<List<Model>> getData(List<String> identifiers) {
    return Observable
        .from(identifiers)
        .concatMap(identifier -> getDataPerItem(identifier))
        .reduce(new ArrayList<Model>(), (list, next) -> list.addAll(next));
}
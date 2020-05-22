static <T> Observable<List<T>> sortListItem(Observable<List<T>> source,
        Comparator<? super T> comparator) {
    return source.flatMapIterable(v -> v)
                .toSortedList(comparator)
                .toObservable();
}

compositeDisposable.add(manager.getObservable()
        .map(objects -> modelMapper.map(objects))
        .map(modelObjects -> {
            cache.save(modelObjects);
            return modelObjects ;
        })
        .compose(ThisClass::sortListItem)
        .map(modelObjects -> viewModelMapper.map(modelObjects))
        .subscribe(this::onObjectsLoaded));
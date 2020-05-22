public Observable<List<Entity>> getEntities() {
    invalidateCacheIfNeeded();
    return Observable
            .concat(cachedEntities(), networkEntities())
            .first();
}
@SuppressWarnings("unchecked")
E cachedEntity = (E) cache.get(cacheKey);

if (cachedEntity != null) {
    entity = cachedEntity;          
}
else {
    entity = pm.getObjectById(Eclass, key);
    cache.put(cacheKey, pm.detachCopy(entity));
}
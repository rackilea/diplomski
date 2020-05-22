public void clearCache() {
    if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
        CacheRegistryUtil.clear(LayoutImpl.class.getName());
    }

    EntityCacheUtil.clearCache(LayoutImpl.class.getName());
    FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
    FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
}